package com.sripad.unimas.services;

import com.sripad.unimas.model.Student;
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

        if(obtainedPassword == password){
            sql = "SELECT * FROM student where email = ?";
            List<Student> studentList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class), email);
            return studentList.get(0);
        }else{
            return new Student();
        }

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
