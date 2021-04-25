package com.sripad.unimas.controller;


import com.sripad.unimas.model.*;
import com.sripad.unimas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentServices studentService;

    @GetMapping("/myprofile")
    public ResponseEntity<?>  myProfile(@CookieValue(value="sroll") String sroll){
        if(sroll.length() < 9){
            return ResponseEntity.status(400).body("Bad Request");
        }
        Student s = studentService.getStudent(sroll);
        return ResponseEntity.status(200).body(s);
    }

//    @GetMapping("/")
//    @ResponseBody
//    List<Student> all() {
//        return studentService.printAllStudents();
//    }

//    @PathVariable String sroll
    @GetMapping("/srollgrades")
    @ResponseBody
    public ResponseEntity<?> getStudentGradesBySroll(@CookieValue(value="sroll" ) String sroll){
        if(sroll.length() < 9){
            return ResponseEntity.status(400).body("Bad Request");
        }
        List<StudentGrades> sgrades = studentService.getGradesBySroll(sroll);
        List<StudentGPA> sgpa = studentService.getCGBySroll(sroll);

        StudentDetails studentDetails = new StudentDetails( sgrades, sgpa);
        return ResponseEntity.status(200).body(studentDetails);
    }

    @GetMapping("/srollreg")
    @ResponseBody
    public ResponseEntity<?> getStudentRegistrationBySroll(@CookieValue(value="sroll" ) String sroll){
        if(sroll.length() < 9){
            return ResponseEntity.status(400).body("Bad Request");
        }
        List<RegisteredCourses> coursesList = studentService.getStudentRegistrationDetails(sroll);
        boolean registered = studentService.isRegistered(sroll);
        List<OfferedCourses> offeredCourses =  studentService.getOfferedCourses(sroll);


        StudentRegistrationDetails studentDetails = new StudentRegistrationDetails(coursesList, registered, offeredCourses);
        return ResponseEntity.status(200).body(studentDetails);
    }


    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@CookieValue(value="sroll" ) String sroll, @RequestBody List<Integer> courseIDs){
        if(sroll.length() < 9){
            return ResponseEntity.status(400).body("Bad Request");
        }
        String errors = studentService.registerStudent(sroll, courseIDs);
        if(errors.length() > 0){
            return ResponseEntity.status(400).body(errors);
        }
        else   return  ResponseEntity.status(200).body("All OK");
    }

    @PostMapping("/student")
    @ResponseBody
    public ResponseEntity<String> addStudentController(@RequestBody Student stu){
        if(studentService.addStudent(stu)){
            return  new ResponseEntity<>("New Student added Successful", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("New Student could not be added. Transaction Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/student")
    @ResponseBody
    public ResponseEntity<String> updateStudentController(@RequestBody Student stu){
        if(studentService.updateStudent(stu)){
            return  new ResponseEntity<>("Student modified Successfully", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("Student couldnot be updated. Transaction Failed", HttpStatus.BAD_REQUEST);
        }
    }

}
