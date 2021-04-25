package com.sripad.unimas.services;

import com.sripad.unimas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Component
public class StudentServices {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Student getStudent(String sroll ){
        String sql = "SELECT * FROM STUDENT WHERE SROLL = ?";
        Object[] params = {sroll};
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Student.class), params);
    }

    public Student authenticateStudent(String email, String password){
        String sql = "SELECT password FROM PERSON WHERE EMAIL = ?";
        Object[] params = {email};
        String obtainedPassword = jdbcTemplate.queryForObject(sql, String.class,params);

        System.out.println("Received : " + password + " obtained from db : " + obtainedPassword);

        if(obtainedPassword.equals(password)){
            sql = "SELECT * FROM student where email = ?";
            List<Student> studentList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class), email);
            System.out.println(studentList.get(0));
            return studentList.get(0);
        }else{
            return new Student();
        }

    }
    public List<RegisteredCourses> getStudentRegistrationDetails(String sroll){
        String sql = "SELECT * FROM registration natural join course where sroll = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(RegisteredCourses.class), sroll);
    }

    public List<StudentGrades> getGradesBySroll(String sroll){
        String sql = "SELECT sroll, cname, grade, semno, ctype,credits FROM score natural join course where sroll = ? order by semno";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StudentGrades.class), sroll);
    }

    public List<StudentGPA> getCGBySroll(String sroll){
        String sql = "SELECT sroll,gpa, semno FROM GPALIST  where sroll = ? order by semno";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StudentGPA.class), sroll);
    }

    public boolean isRegistered(String sroll){
        List<RegisteredCourses> courseList = getStudentRegistrationDetails(sroll);

        String sql =  "SELECT batch FROM STUDENT WHERE SROLL = ?";
        Object[] params = {sroll};
        int batch = jdbcTemplate.queryForObject(sql, Integer.class, params);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int reqSemno;

        if(month >= 1 && month <=6){
            if(year - batch <= 1){
                reqSemno = 2;
            }else if(year - batch <= 2){
                reqSemno = 4;
            }else if(year - batch <= 3){
                reqSemno = 6;
            }
            else reqSemno = 8;
        }else{
            if(year - batch <= 0){
                reqSemno = 1;
            }else if(year - batch <= 1){
                reqSemno = 3;
            }else if(year - batch <= 2){
                reqSemno = 5;
            }
            else reqSemno = 7;
        }
        for(RegisteredCourses rc: courseList){
            if(reqSemno == rc.getSemno()) {
                return true;
            }
        }
        return false;
    }

    public List<OfferedCourses> getOfferedCourses(String sroll){
        String sql =  "SELECT dept_id FROM STUDENT WHERE SROLL = ?";
        Object[] params = {sroll};
        int dept_id = jdbcTemplate.queryForObject(sql, Integer.class, params);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int reqSemno;
        String str = Integer.toString(year);

        if(month <= 6){
            str += 'S';
        }else str += 'A';

        System.out.println(str);
        sql =  "SELECT course_id , cname ,ctype ,  semno , CREDITS FROM TEACHES T NATURAL JOIN COURSE WHERE T.YEAR = ? AND (DEPT_ID = ? or DEPT_ID = 3)";
        Object[] params2 = {str, dept_id};
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OfferedCourses.class), params2);
    }

    public String registerStudent(String sroll, List<Integer> courseIDs){
        String errors = null;
        for(int x: courseIDs){
            try{
                int c = jdbcTemplate.update(
                        "INSERT INTO registration (sroll, course_id) VALUES (?, ?)",
                        sroll, x
                );
                System.out.println(c + " is C and x is " + x + " sroll is " + sroll);
            }
            catch (DataAccessException error){
                errors += error.getCause().toString().substring(33);
                System.out.println("Error is " + error.getCause().toString().substring(33)  );
            }
        }
        return errors;
    }

    public List<Object> getAttendance(String sroll){
        String sql =  "SELECT C.CNAME, C.COURSE_ID, K.TOTAL_DAYS,K.PRESENT_DAYS FROM COURSE C, (SELECT * FROM (SELECT COURSE_ID, COUNT(*) AS TOTAL_DAYS FROM ATTENDANCE WHERE SROLL = ? GROUP BY COURSE_ID) NATURAL JOIN (SELECT COURSE_ID, COUNT(*) AS PRESENT_DAYS FROM ATTENDANCE WHERE STATUS = 'P' AND SROLL = ?    GROUP BY COURSE_ID)) K WHERE C.COURSE_ID = K.COURSE_ID ORDER BY COURSE_ID DESC ";
        Object[] params = {sroll, sroll};
        List<Map<String, Object>>  rows = jdbcTemplate.queryForList(sql, params);
        List<Object> attendance = new ArrayList<>();
        for (Map<String, Object> rowMap : rows) {
            Object [] obj = new Object[]{rowMap.get("CNAME"), rowMap.get("COURSE_ID"), rowMap.get("PRESENT_DAYS"), rowMap.get("TOTAL_DAYS")  };
            attendance.add(obj);
        }
        return attendance;
    }


    public List<Object> getCurrentAttendance(String sroll){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        String str = Integer.toString(year);

        if(month <= 6){
            month = 1;
        }else month = 7;

        String mm = "0" + Integer.toString(month);

        String mm2 = "0" + Integer.toString(month + 5);

        String sql =  "SELECT C.CNAME, C.COURSE_ID,K.ADATE FROM COURSE C,  (SELECT COURSE_ID, ADATE FROM ATTENDANCE WHERE STATUS = 'A' AND  ADATE > TO_DATE('01-" + mm +"-" + str  + "', 'DD-MM-YYYY' ) AND  ADATE <  TO_DATE('30-" + mm2 +"-" + str  + "', 'DD-MM-YYYY' )  AND SROLL = ? ) K WHERE C.COURSE_ID = K.COURSE_ID ";
        Object[] params = {sroll};
        List<Map<String, Object>>  rows = jdbcTemplate.queryForList(sql, params);
        List<Object> attendance = new ArrayList<>();
        for (Map<String, Object> rowMap : rows) {
            Object [] obj = new Object[]{rowMap.get("CNAME"), rowMap.get("COURSE_ID"), rowMap.get("ADATE")   };
            attendance.add(obj);
        }
        return attendance;
    }

    public List<Student> printAllStudents(){
        String sql = "SELECT * FROM student";

        List<Student> studentList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));

        for(Student stu : studentList) {
            System.out.println(stu);
        }
        return studentList;
    }

    public boolean addStudent(Student s){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("student");


        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(s);

        int result = insertActor.execute(paramSource);

        if (result > 0) {
            System.out.println("Insert successfully.");
            return true;
        }else return false;
    }

    public boolean updateStudent(Student s){

        String sql = "UPDATE STUDENT SET SNAME=?,   PHONE = ?, ADDRESS = ? WHERE SROLL=?";
        Object[] params = {s.getSname(),  s.getPhone(), s.getAddress(),s.getSroll()};
        int result = jdbcTemplate.update(sql, params);

        if (result > 0) {
            System.out.println("Update successfully.");
            return true;
        }
        else return false;
    }
}
