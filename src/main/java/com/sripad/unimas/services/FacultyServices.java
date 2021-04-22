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

    public Faculty getFaculty(int fid ){
        String sql = "SELECT * FROM Faculty WHERE Faculty_id = ?";
        Object[] params = {fid};
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Faculty.class), params);
    }

    public int getDeptIfHOD(int f){
        String sql = "SELECT  dept_id  FROM DEPARTMENT WHERE hod_id = " + f;
        try{
            int x =   jdbcTemplate.queryForObject(sql, Integer.class);
            return x;
        }
        catch (org.springframework.dao.EmptyResultDataAccessException e ){
//            System.out.println("Error " + e);
            return -1;
        }
    }

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


    public Object getCurrentCourseStudents(int faculty_id){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';

        String sql2 =  "SELECT C.CNAME, R.SROLL,S.SNAME,S.BATCH, C.SEMNO,C.COURSE_ID FROM TEACHES T , REG_TOREAD R, STUDENT S, COURSE C " +
                "WHERE C.COURSE_ID = T.COURSE_ID AND S.SROLL = R.SROLL AND R.TOREAD = ? AND T.YEAR = ?  AND T.course_id =  R.course_id AND T.FACULTY_ID = ?";
        Object[] params2 = {year , str,faculty_id };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql2, params2);

        Map<String, List<Object>> hh = new HashMap<>();

        int total = rows.size();
        Set<String> courses = new HashSet<String>();
        String course;
        for(int i = 0; i < total; i++){
            course = (String) rows.get(i).get("CNAME");
            Object details = new Object[]{    rows.get(i).get("SROLL") ,   rows.get(i).get("SNAME") ,  rows.get(i).get("BATCH"), rows.get(i).get("SEMNO"),rows.get(i).get("COURSE_ID")  };
            courses.add(course);
            hh.putIfAbsent( course  , new ArrayList<Object>());
            hh.get( course ).add(details);
        }

        Object obj = new Object[]{courses, hh, hh.size()};
        return obj;
    }
    public Object currentAttendance(int faculty_id){
        Object obj = getCurrentCourseStudents(faculty_id);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';

        String sql2 =  "SELECT C.CNAME, R.SROLL,S.SNAME,S.BATCH, C.SEMNO,C.COURSE_ID FROM TEACHES T , REG_TOREAD R, STUDENT S, COURSE C " +
                "WHERE C.COURSE_ID = T.COURSE_ID AND S.SROLL = R.SROLL AND R.TOREAD = ? AND T.YEAR = ?  AND T.course_id =  R.course_id AND T.FACULTY_ID = ?";
        Object[] params2 = {year , str,faculty_id };
        System.out.println(obj.getClass());
        return params2;
    }
    public  Object  getAllCourseStudents(int faculty_id){

        String sql = " SELECT S.SNAME, S.SROLL, G.GRADE, R.TOREAD, R.COURSE_ID,S.BATCH FROM REG_TOREAD R, SCORE G, STUDENT S " +
                "WHERE R.SROLL = G.SROLL AND G.SROLL = S.SROLL AND R.COURSE_ID = G.COURSE_ID  ";

        String sql2 =  "SELECT   T.YEAR , C.CNAME,  C.COURSE_ID, C.SEMNO FROM TEACHES T ,  " +
                "  COURSE C WHERE C.COURSE_ID = T.COURSE_ID  AND T.FACULTY_ID = ?";
        Object[] params2 = { faculty_id };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(sql2, params2);

        Map<String, List<Object>> hh = new HashMap<>();

        int total = rows.size(), total2 = rows2.size();
        Set<String> courses = new HashSet<String>();
        String course;

        for(int i = 0; i < total; i++){
            for(int j = 0; j < total2;j++){
                if ( (((BigDecimal)rows.get(i).get("TOREAD")).intValue() ==  Integer.parseInt( ((String)rows2.get(j).get("YEAR")).substring(0,4)))   && rows.get(i).get("COURSE_ID").equals(rows2.get(j).get("COURSE_ID") ))
                {
//                    System.out.println("O");
                    course = (String) rows2.get(j).get("CNAME");
                    Object details = new Object[]{ rows.get(i).get("SROLL") ,  rows.get(i).get("SNAME") ,  rows.get(i).get("BATCH"), rows2.get(j).get("SEMNO"), rows.get(i).get("GRADE"),rows2.get(j).get("COURSE_ID")   };
                    courses.add(course);
                    hh.putIfAbsent( course  , new ArrayList<Object>());
                    hh.get( course ).add(details);
                }
            }
        }
        Object obj = new Object[]{courses, hh, hh.size()};
        return obj;
    }

}