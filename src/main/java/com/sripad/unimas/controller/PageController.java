package com.sripad.unimas.controller;

import com.sripad.unimas.model.AuthenticationRequest;
import com.sripad.unimas.model.Student;
import com.sripad.unimas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    @Autowired
    StudentServices studentService;

    @GetMapping("/")
    public String home(){
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout( HttpServletResponse response){
        Cookie cookie = new Cookie("sroll", null); // Not necessary, but saves bandwidth.
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        Cookie cookie2 = new Cookie("program", null);
        cookie2.setHttpOnly(true);
        cookie2.setMaxAge(0);
        response.addCookie(cookie2);
        Cookie cookie3 = new Cookie("faculty_id", null);
        cookie3.setHttpOnly(true);
        cookie3.setMaxAge(0);
        response.addCookie(cookie3);
        Cookie cookie4 = new Cookie("dept_id", null);
        cookie4.setHttpOnly(true);
        cookie4.setMaxAge(0);
        response.addCookie(cookie4);
        return "redirect:/";
    }

    @PostMapping("/auth")
    @ResponseBody
    public ResponseEntity<?> authStudent(@RequestBody AuthenticationRequest auth, HttpServletResponse response){

        Student s = studentService.authenticateStudent(auth.getEmail(), auth.getPassword());
        if(s.getSroll() != null){
            response.addCookie( new Cookie("sroll", s.getSroll()) );
            response.addCookie( new Cookie("program", s.getProgram()) );
            return ResponseEntity.ok(s);
        }else{
            return ResponseEntity.status(400).body("Incorrect email or Password");
        }
    }

    @GetMapping("/profile")
    public String studentProfile(@CookieValue(value="sroll", required = false) String sroll){
        if(sroll == null || sroll.length() < 9){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "student/profile/sProfile.html";
    }

    @GetMapping("/registration")
    public String studentRegistration(@CookieValue(value="sroll", required = false) String sroll){
        if(sroll == null || sroll.length() < 9){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "student/register/register.html";
    }
    @GetMapping("/grades")
    public String studentGrades(@CookieValue(value="sroll", required = false) String sroll){
        if(sroll == null || sroll.length() < 9){
            System.out.println("Good try..");
            return "redirect:/";
        }
        System.out.println("Hi");
        return "student/results/results.html";
    }


    @GetMapping("/facultyprofile")
    public String facultyProfile(@CookieValue(value="faculty_id", required = false) String fac_id){
        if(fac_id == null ){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "faculty/profile/profile.html";
    }

    @GetMapping("/prev_grades")
    public String prevGrades(@CookieValue(value="faculty_id", required = false) String fac_id){
        if(fac_id == null ){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "faculty/prev_grades/prev_grades.html";
    }

    @GetMapping("/curr_grades")
    public String currGrades(@CookieValue(value="faculty_id", required = false) String fac_id){
        if(fac_id == null ){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "faculty/curr_grades/curr_grade.html";
    }

    @GetMapping("/curr_attend")
    public String currAttend(@CookieValue(value="faculty_id", required = false) String fac_id){
        if(fac_id == null ){
            System.out.println("Good try..");
            return "redirect:/";
        }
        return "faculty/curr_attend.html";
    }

}
