package com.sripad.unimas.services;

import com.sripad.unimas.model.Student;
import com.sripad.unimas.model.faculty.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AdminServices {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int updatepassword(String email , String password){
        System.out.println(email + " oo " + password);
//        int x =
//        System.out.println(x);
        return jdbcTemplate.update("UPDATE PERSON SET PASSWORD= ?  WHERE EMAIL = ?", password,email);
    }

    public List<Student> getStudents(int dept_id){
        String sql = "SELECT * FROM Student WHERE DEPT_ID = ? ORDER BY BATCH DESC";
        Object[] params = {dept_id};

        List<Student> studentList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class), params);

        for(Student stu : studentList) {
            System.out.println(stu);
        }
        return studentList;
    }
    public List<Faculty> getFaculty(int dept_id){
        String sql = "SELECT * FROM Faculty WHERE DEPT_ID = ? ";
        Object[] params = {dept_id};

        List<Faculty> facultyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Faculty.class), params);

        for(Faculty stu : facultyList) {
            System.out.println(stu);
        }
        return facultyList;
    }

    public List<Object> getToppers(int dept_id){
        String sql = "SELECT C.SROLL,C.SNAME, C.BATCH, C.PROGRAM , C.CGPA FROM CGPALIST C WHERE C.DEPT_ID = ? AND (C.BATCH, C.CGPA) IN (SELECT  BATCH,  MAX(CGPA) FROM CGPALIST GROUP BY BATCH ) ORDER BY BATCH";
        Object[] params = {dept_id};
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);

        List<Object> toppersList = new ArrayList<>();
        for (Map<String, Object> rowMap : rows) {
            Object [] obj = new Object[]{rowMap.get("SROLL"), rowMap.get("SNAME"), rowMap.get("BATCH"), rowMap.get("PROGRAM"),rowMap.get("CGPA"), };
            toppersList.add(obj);
        }
        return toppersList;

    }



}
