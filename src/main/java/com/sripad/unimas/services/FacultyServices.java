package com.sripad.unimas.services;


import com.sripad.unimas.model.OfferedCourses;
import com.sripad.unimas.model.faculty.Faculty;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class FacultyServices {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public Faculty authenticateFaculty(String email, String password){
        String sql = "SELECT password FROM PERSON WHERE EMAIL = ?";
        Object[] params = {email};
        String obtainedPassword = jdbcTemplate.queryForObject(sql, String.class,params);

        System.out.println("Received : " + password + " obtained from db : " + obtainedPassword);

        if(obtainedPassword.equals(password)){
            sql = "SELECT * FROM faculty where email = ?";
            List<Faculty> facultyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Faculty.class), email);
            System.out.println(facultyList.get(0));
            return facultyList.get(0);
        }else{
            return new Faculty();
        }

    }


    public Map<String, List<Object>> getCurrentCourseStudents(int faculty_id){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';


        String sql2 =  "SELECT C.CNAME, R.SROLL,S.SNAME,S.BATCH, C.SEMNO FROM TEACHES T , REG_TOREAD R, STUDENT S, COURSE C WHERE C.COURSE_ID = T.COURSE_ID AND S.SROLL = R.SROLL AND R.TOREAD = ? AND T.YEAR = ?  AND T.course_id =  R.course_id AND T.FACULTY_ID = ?";
        Object[] params2 = {year , str,faculty_id };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql2, params2);

        Map<String, List<Object>> hh = new HashMap<>();

        int total = rows.size();
        for(int i = 0; i < total; i++){

            Object details = new Object[]{    rows.get(i).get("SROLL") ,   rows.get(i).get("SNAME") ,  rows.get(i).get("BATCH"), rows.get(i).get("SEMNO")  };
            hh.putIfAbsent(  (String) rows.get(i).get("CNAME") , new ArrayList<Object>());
            hh.get( (String) rows.get(i).get("CNAME") ).add(details);
        }
        return hh;
    }
    public Map<String, List<Object>> getAllCourseStudents(int faculty_id){

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';


        String sql2 =  "SELECT R.TOREAD, T.YEAR , C.CNAME, R.SROLL,S.SNAME,S.BATCH, C.SEMNO FROM TEACHES T , REG_TOREAD R, STUDENT S, COURSE C WHERE C.COURSE_ID = T.COURSE_ID AND S.SROLL = R.SROLL   AND T.course_id =  R.course_id AND T.FACULTY_ID = ?";

        String sql = "SELECT * FROM (SELECT * FROM STUDENT S, SCROLL G WHERE S.SROLL = G.SROLL) P"  +
                ", (SELECT R.TOREAD, T.YEAR ,R.SROLL, C.CNAME,C.SEMNO,C.SOURSE_ID FROM TEACHES T , COURSE C, REG_TOREAD R  WHERE C.COURSE_ID = T.COURSE_ID AND T.FACULTY_ID = ?) K" +
                "WHERE P.COURSE_ID = K.COURSE_ID AND K.SROLL = P.SROLL";


        Object[] params2 = { faculty_id };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params2);

        Map<String, List<Object>> hh = new HashMap<>();

        int total = rows.size();
        for(int i = 0; i < total; i++){

            if( ( (BigDecimal)rows.get(i).get("TOREAD")).intValue() ==  Integer.parseInt( ((String)   rows.get(i).get("YEAR")).substring(0,4)  ) ) {
                Object details = new Object[]{    rows.get(i).get("SROLL") ,   rows.get(i).get("SNAME") ,  rows.get(i).get("BATCH"), rows.get(i).get("SEMNO")  };
                hh.putIfAbsent(  (String) rows.get(i).get("CNAME") , new ArrayList<Object>());
                hh.get( (String) rows.get(i).get("CNAME") ).add(details);
            }

        }
        return hh;
    }

}