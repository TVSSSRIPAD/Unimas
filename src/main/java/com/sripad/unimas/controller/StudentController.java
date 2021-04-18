package com.sripad.unimas.controller;


import com.sripad.unimas.model.AuthenticationRequest;
import com.sripad.unimas.model.AuthenticationResponse;
import com.sripad.unimas.model.Student;
import com.sripad.unimas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServices studentService;

    @GetMapping("/")
    @ResponseBody
    List<Student> all() {
        return studentService.printAllStudents();
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authStudent(@RequestBody AuthenticationRequest auth){
        Student s = studentService.authenticateStudent(auth.getUsername(), auth.getPassword());
        if(s.getSroll() != null){
            return ResponseEntity.ok(s);
        }else{
            return ResponseEntity.status(400).body("Incorrect email or Pasword");
        }
    }

    @PostMapping("/student")
    ResponseEntity<String> addStudentController(@RequestBody Student stu){
        if(studentService.addStudent(stu)){
            return  new ResponseEntity<>("New Student added Successful", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("New Student could not be added. Transaction Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/student")
    ResponseEntity<String> updateStudentController(@RequestBody Student stu){
        if(studentService.updateStudent(stu)){
            return  new ResponseEntity<>("Student modified Successfully", HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>("Student couldnot be updated. Transaction Failed", HttpStatus.BAD_REQUEST);
        }
    }

}
