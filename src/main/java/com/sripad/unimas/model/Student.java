package com.sripad.unimas.model;

public class Student {
    String sroll;
    String sname;
    int batch;
    int dept_id;
    String email;
    String phone;
    Character gender;
    String program;
    String address;
    private String dob;

    public void setSroll(String sroll) {
        this.sroll = sroll;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }


    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sroll='" + sroll + '\'' +
                ", sname='" + sname + '\'' +
                ", batch=" + batch +
                ", dept_id=" + dept_id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", program='" + program + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSroll() {
        return sroll;
    }

    public String getSname() {
        return sname;
    }

    public int getBatch() {
        return batch;
    }

    public int getDept_id() {
        return dept_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Character getGender() {
        return gender;
    }




    public String getDob() {
        return dob;
    }
}
