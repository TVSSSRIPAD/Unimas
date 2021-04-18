package com.sripad.unimas.controller;


import com.sripad.unimas.model.*;
import com.sripad.unimas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentServices studentService;

    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/studentpage")
    public String studentPage(){
        return "index.html";
    }

    @GetMapping("/studentprofile")
    public String studentProfile(){
        return "studentprofile.html";
    }
//    @GetMapping("/")
//    @ResponseBody
//    List<Student> all() {
//        return studentService.printAllStudents();
//    }

    @GetMapping("/srollgrades/{sroll}")
    @ResponseBody
    public ResponseEntity<?> getStudentGradesBySroll(@PathVariable String sroll){

        List<StudentGrades> sgrades = studentService.getGradesBySroll(sroll);
        List<StudentGPA> sgpa = studentService.getCGBySroll(sroll);

        StudentDetails studentDetails = new StudentDetails( sgrades, sgpa);
        return ResponseEntity.status(200).body(studentDetails);
    }

    @GetMapping("/srollreg/{sroll}")
    @ResponseBody
    public ResponseEntity<?> getStudentRegistrationBySroll(@PathVariable String sroll){
        List<RegisteredCourses> coursesList = studentService.getStudentRegistrationDetails(sroll);
        boolean registered = studentService.isRegistered(sroll);
        List<OfferedCourses> offeredCourses =  studentService.getOfferedCourses(sroll);


        StudentRegistrationDetails studentDetails = new StudentRegistrationDetails(coursesList, registered, offeredCourses);
        return ResponseEntity.status(200).body(studentDetails);
    }

    @PostMapping("/auth")
    @ResponseBody
    public ResponseEntity<?> authStudent(@RequestBody AuthenticationRequest auth){
        Student s = studentService.authenticateStudent(auth.getEmail(), auth.getPassword());
        if(s.getSroll() != null){
            return ResponseEntity.ok(s);
        }else{
            return ResponseEntity.status(400).body("Incorrect email or Password");
        }
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
