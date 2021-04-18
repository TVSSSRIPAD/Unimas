package com.sripad.unimas.model;


import java.io.Serializable;

public class AuthenticationResponse implements Serializable {


    boolean success;
    Student student;

    public AuthenticationResponse(boolean success, Student student) {
        this.success = success;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public boolean getSuccess() {
        return success;
    }
}
