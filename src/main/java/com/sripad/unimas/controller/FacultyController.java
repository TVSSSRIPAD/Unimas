package com.sripad.unimas.controller;

import com.sripad.unimas.model.*;

import com.sripad.unimas.model.faculty.Faculty;
import com.sripad.unimas.services.FacultyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class FacultyController {

    @Autowired
    FacultyServices facultyServices;

    @GetMapping("/facprofile")
    @ResponseBody
    public ResponseEntity<?> getFaculty(@CookieValue(value="faculty_id") String fac_id){
        if(fac_id == null ){
            return ResponseEntity.status(400).body("Bad Request");
        }
        Faculty s = facultyServices.getFaculty(Integer.parseInt(fac_id));
        return ResponseEntity.status(200).body(s);
    }

    @PostMapping("/facultyauth")
    @ResponseBody
    public ResponseEntity<?> authFaculty(@RequestBody AuthenticationRequest auth, HttpServletResponse response){
        Faculty f = facultyServices.authenticateFaculty(auth.getEmail(), auth.getPassword());
        if(f.getEmail() != null){
            response.addCookie( new Cookie("faculty_id",  Integer.toString(f.getFaculty_id()) ) );
            System.out.println(facultyServices.getDeptIfHOD(f.getFaculty_id()));
            return ResponseEntity.ok(f);
        }else{
            return ResponseEntity.status(400).body("Incorrect email or Password");
        }
    }

    @GetMapping("/faccurr")
    @ResponseBody
    public ResponseEntity<?> currStudents(@CookieValue(value="faculty_id" ) String fac_id){
        Object obj = facultyServices.getCurrentCourseStudents(Integer.parseInt(fac_id)) ;
        return ResponseEntity.status(200).body(obj);
    }

    @GetMapping("/facall")
    @ResponseBody
    public ResponseEntity<?> allStudents(@CookieValue(value="faculty_id" ) String fac_id){
         Object objs = facultyServices.getAllCourseStudents(Integer.parseInt(fac_id));

        return ResponseEntity.status(200).body(objs);
    }
//
    @PostMapping("/faculty")
    public ResponseEntity<String> giveGrades( ){
         return new ResponseEntity<>("New Student could not be added. Transaction Failed", HttpStatus.BAD_REQUEST);
    }
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
