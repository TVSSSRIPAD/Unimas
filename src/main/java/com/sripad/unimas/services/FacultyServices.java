package com.sripad.unimas.services;


import com.sripad.unimas.model.faculty.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacultyServices {

    @Autowired
    JdbcTemplate jdbcTemplate;

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

}