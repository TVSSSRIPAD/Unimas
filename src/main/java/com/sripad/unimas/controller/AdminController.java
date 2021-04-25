package com.sripad.unimas.controller;

import com.sripad.unimas.model.Student;
import com.sripad.unimas.model.faculty.Faculty;
import com.sripad.unimas.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminServices adminServices;


    @GetMapping("/gettoppers")
    @ResponseBody
    public ResponseEntity<?> getToppers(@CookieValue(value="dept_id") String dept_id, HttpServletResponse response){
        if(dept_id == null || dept_id.equals("-1") ){
            return ResponseEntity.status(400).body("Bad Request. LogOut and LogIn again properly");
        }
        int dept =  Integer.parseInt(dept_id);
        List<Object> toppers = adminServices.getToppers(dept);
        return ResponseEntity.status(200).body(toppers);
    }


    @GetMapping("/getfac")
    @ResponseBody
    public ResponseEntity<?> getFac(@CookieValue(value="dept_id") String dept_id, HttpServletResponse response){
        if(dept_id == null || dept_id.equals("-1")  ){
            return ResponseEntity.status(400).body("Bad Request. LogOut and LogIn again properly");
        }
        int dept =  Integer.parseInt(dept_id);
        List<Faculty> faculties = adminServices.getFaculty(dept);
        return ResponseEntity.status(200).body(faculties);
    }


    @GetMapping("/getstu")
    @ResponseBody
    public ResponseEntity<?> getStudents(@CookieValue(value="dept_id") String dept_id, HttpServletResponse response){
        if(dept_id == null || dept_id.equals("-1") ){
            return ResponseEntity.status(400).body("Bad Request. LogOut and LogIn again properly");
        }
        int dept =  Integer.parseInt(dept_id);
        List<Student> students = adminServices.getStudents(dept);
        return ResponseEntity.status(200).body(students);
    }




}
