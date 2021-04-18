package com.sripad.unimas.services;

import com.sripad.unimas.model.RegisteredCourses;
import com.sripad.unimas.model.Student;
import com.sripad.unimas.model.StudentGPA;
import com.sripad.unimas.model.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServices {
    @Autowired
    JdbcTemplate jdbcTemplate;

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
        List<RegisteredCourses> courseList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(RegisteredCourses.class), sroll);
        return courseList;
    }

    public List<StudentGrades> getGradesBySroll(String sroll){
        String sql = "SELECT sroll, cname, grade, semno FROM score natural join course where sroll = ?";
        List<StudentGrades> gradeList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StudentGrades.class), sroll);
        return gradeList;
    }

    public List<StudentGPA> getCGBySroll(String sroll){
        String sql = "SELECT sroll,gpa, semno FROM GPALIST  where sroll = ?";
        List<StudentGPA> gradeList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StudentGPA.class), sroll);
        return gradeList;
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
