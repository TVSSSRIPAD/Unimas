package com.sripad.unimas.services;

import com.sripad.unimas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServices {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> printAllStudents(){
        String sql = "SELECT * FROM student";

        List<Student> studentList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));

        for(Student stu : studentList) {
            System.out.println(stu);
        }
        return studentList;
    }
}
