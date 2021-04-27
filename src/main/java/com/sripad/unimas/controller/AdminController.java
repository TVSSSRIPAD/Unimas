package com.sripad.unimas.controller;

import com.sripad.unimas.model.AuthenticationRequest;
import com.sripad.unimas.model.Student;
import com.sripad.unimas.model.faculty.Faculty;
import com.sripad.unimas.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/updatepassword")
    @ResponseBody
    public  ResponseEntity<?> updatePassword(@CookieValue(value="dept_id") String dept_id, @RequestBody AuthenticationRequest req){
        System.out.println(req.getEmail() + " oo " + req.getPassword());
        if(dept_id == null || dept_id.equals("-1")){
            return  new ResponseEntity<>("Password couldnot be updated. Transaction Failed2", HttpStatus.BAD_REQUEST);
        }else{
            int x = adminServices.updatepassword(req.getEmail(), req.getPassword());

            System.out.println(x);
            if(x > 0){
                return  new ResponseEntity<>("Password updated Successfully", HttpStatus.OK);
            }
            else{
                return  new ResponseEntity<>("Password couldnot be updated. Transaction Failed", HttpStatus.BAD_REQUEST);
            }
        }
    }


}
