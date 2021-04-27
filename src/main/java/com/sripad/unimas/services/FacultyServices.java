package com.sripad.unimas.services;


import com.sripad.unimas.model.OfferedCourses;
import com.sripad.unimas.model.faculty.Attend;
import com.sripad.unimas.model.faculty.Faculty;
import com.sripad.unimas.model.faculty.Grade;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class FacultyServices {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate njdbc;

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


    public String gradeStudent(List<Grade> grades){
        String errors = null;
        for(Grade x: grades){
            try{
                int c = jdbcTemplate.update(
                        "INSERT INTO score (sroll, course_id, grade) VALUES (?, ?, ?)",
                        x.getSroll(), x.getCourse_id(), x.getGrade()

                );
                System.out.println(c + " is C ");
            }
            catch (DataAccessException error){
                errors += error.getCause().toString().substring(33);
                System.out.println("Error is " + error.getCause().toString().substring(33)  );
            }
        }
        return errors;
    }

    public String attendStudent(List<Attend> attends){
        String errors = null;



        for(Attend x: attends){
            try{
                MapSqlParameterSource parameters = new MapSqlParameterSource();

                parameters.addValue("sroll", x.getSroll() );
//                parameters.addValue("cid", );
                parameters.addValue("adate", x.getAdate() , Types.DATE);
//                parameters.addValue("status",  );

                int c = njdbc.update("INSERT INTO ATTENDANCE (sroll, course_id, adate, status) VALUES" +
                        "(:sroll,  x.getCourse_id(), :adate, x.getStatus())", parameters);
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                String inputDateStr= x.getAdate();
                Date date = outputFormat.parse("29-04-2021");

//                String outputDateStr = outputFormat.format(x.getAdate());
//                date = outputFormat
                System.out.println(x.getAdate() + " " + x.getSroll() + " " + x.getCourse_id() + " "   );
//                int c = jdbcTemplate.update(
//                        "INSERT INTO ATTENDANCE (sroll, course_id, adate, status) VALUES (?, ?, ?,?)",
//                        x.getSroll(), x.getCourse_id(), date, 'P'
//                );
                System.out.println(c + " is C ");
            }
            catch (DataAccessException | ParseException error){
                errors += error.getCause().toString().substring(33);

                System.out.println("Error is " + error.getCause().toString().substring(33 ));
            }
        }
        return errors;
    }

    public Object offerCoursesList(int fac_id){

        String sql = "SELECT  dept_id  FROM FACULTY WHERE faculty_id = " + fac_id;

        int dept =   jdbcTemplate.queryForObject(sql, Integer.class);
        Calendar c = Calendar.getInstance();
        int ans = 1;
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        if(month <= 6) ans = 0;

        String str = Integer.toString(year);
        if(month <= 6){
            str += 'S';
        }else str += 'A';
        System.out.println(str);
        String sql2  = "SELECT CNAME, COURSE_ID, CTYPE, CREDITS, SEMNO FROM COURSE WHERE dept_id = ? AND " +
                "((COURSE_ID) NOT IN (SELECT COURSE_ID FROM TEACHES T WHERE T.YEAR = ?))" ;

        Object[] params2 = { dept, str };
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql2, params2);


        List<Object> ansList = new ArrayList<>();
        int total = rows.size();
        Set<String> courses = new HashSet<String>();
        String course;
        for(int i = 0; i < total; i++){
            course = (String) rows.get(i).get("CNAME");
            Object details = new Object[]{ rows.get(i).get("CNAME"), rows.get(i).get("COURSE_ID")  , rows.get(i).get("CREDITS"), rows.get(i).get("CTYPE") ,   rows.get(i).get("SEMNO") };

            if(((BigDecimal)rows.get(i).get("SEMNO")).intValue() % 2 == ans){
                courses.add(course);
                ansList.add(details);
            }
//            hh.get( course ).add(details);
        }
        Object obj = new Object[]{ansList, courses.size()};
        return obj;


    }

    public String offerCourses(int fid, List<Integer> cids){
        String errors = null;
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String str = Integer.toString(year);
        if(month <= 6){
            str += 'S';
        }else str += 'A';
        System.out.println(str);
        for(int x: cids){
            try{
                int count = jdbcTemplate.update(
                        "INSERT INTO TEACHES (course_id, year ,faculty_id ) VALUES (?,?, ?)",
                        x, str, fid
                );
                System.out.println(count + " is Count ");
            }
            catch (DataAccessException error){

                String lines[] =  error.getCause().toString().substring(33).split("\\r?\\n");
                errors += lines[0];
                errors += "\n";
                System.out.println("Error is " + error.getCause().toString().substring(33)  );
            }
        }
        return errors;
    }

    public Object myCourses(int fid){
        String sql2  = "SELECT C.CNAME, C.COURSE_ID, C.CTYPE, C.CREDITS, C.SEMNO,T.YEAR FROM COURSE C, TEACHES T WHERE T.COURSE_ID = C.COURSE_ID AND T.FACULTY_ID = ?" ;

        Object[] params2 = { fid };
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql2, params2);

        List<Object> ansList = new ArrayList<>();
        int total = rows.size();
        Set<String> courses = new HashSet<String>();
        String course;
        for(int i = 0; i < total; i++){
            course = (String) rows.get(i).get("CNAME");
            Object details = new Object[]{ rows.get(i).get("CNAME"), rows.get(i).get("COURSE_ID")  , rows.get(i).get("CREDITS"), rows.get(i).get("CTYPE") ,   rows.get(i).get("SEMNO") , rows.get(i).get("YEAR")};

                 courses.add(course);
                ansList.add(details);

//            hh.get( course ).add(details);
        }
        Object obj = new Object[]{ansList, courses.size()};
        return obj;

    }


    public Object getCurrentCourseStudents(int faculty_id){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';

        String sql2 = "SELECT K.CNAME, K.SEMNO,K.COURSE_ID,L.SNAME,L.SROLL,L.BATCH FROM (SELECT C.CNAME, C.SEMNO,C.COURSE_ID  FROM TEACHES T , COURSE C WHERE T.COURSE_ID = C.COURSE_ID AND T.YEAR = ? AND T.FACULTY_ID = ?) K,  " +
                " (SELECT S.SROLL, S.SNAME, S.BATCH , R.COURSE_ID FROM STUDENT S, REG_TOREAD R  WHERE S.SROLL = R.SROLL AND R.TOREAD = ? AND " +
                "(S.SROLL,R.COURSE_ID) IN ((SELECT SROLL, COURSE_ID FROM REGISTRATION R ) MINUS (SELECT SROLL, COURSE_ID FROM SCORE G)) ) L WHERE K.COURSE_ID = L.COURSE_ID";



//        String sql2 =  "SELECT C.CNAME, R.SROLL,S.SNAME,S.BATCH, C.SEMNO,C.COURSE_ID FROM TEACHES T , REG_TOREAD R, STUDENT S, COURSE C " +
//                "WHERE C.COURSE_ID = T.COURSE_ID AND S.SROLL = R.SROLL AND R.TOREAD = ? AND T.YEAR = ?  AND T.course_id =  R.course_id AND T.FACULTY_ID = ?";
        Object[] params2 = { str,faculty_id, year };

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