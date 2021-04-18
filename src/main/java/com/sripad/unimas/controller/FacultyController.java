package com.sripad.unimas.controller;

import com.sripad.unimas.model.*;

import com.sripad.unimas.model.faculty.Faculty;
import com.sripad.unimas.services.FacultyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    FacultyServices facultyServices;

//    @GetMapping("/faculty/{fid}")
//    public ResponseEntity<?> getFacultyDetailsByID(@PathVariable String sroll){
//        List<RegisteredCourses> coursesList = studentService.getStudentRegistrationDetails(sroll);
//
//        List<StudentGrades> sgrades = studentService.getGradesBySroll(sroll);
//        List<StudentGPA> sgpa = studentService.getCGBySroll(sroll);
//
//        StudentDetails studentDetails = new StudentDetails(coursesList, sgrades, sgpa);
//        return ResponseEntity.status(200).body(studentDetails);
//    }

    @PostMapping("/facultyauth")
    public ResponseEntity<?> authFaculty(@RequestBody AuthenticationRequest auth){
        Faculty f = facultyServices.authenticateFaculty(auth.getEmail(), auth.getPassword());
        if(f.getEmail() != null){
            return ResponseEntity.ok(f);
        }else{
            return ResponseEntity.status(400).body("Incorrect email or Password");
        }
    }
//
//    @PostMapping("/faculty")
//    ResponseEntity<String> addStudentController(@RequestBody Student stu){
//        if(studentService.addStudent(stu)){
//            return  new ResponseEntity<>("New Student added Successful", HttpStatus.OK);
//        }
//        else{
//            return  new ResponseEntity<>("New Student could not be added. Transaction Failed", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/faculty")
//    ResponseEntity<String> updateStudentController(@RequestBody Student stu){
//        if(studentService.updateStudent(stu)){
//            return  new ResponseEntity<>("Student modified Successfully", HttpStatus.OK);
//        }
//        else{
//            return  new ResponseEntity<>("Student couldnot be updated. Transaction Failed", HttpStatus.BAD_REQUEST);
//        }
//    }

}
