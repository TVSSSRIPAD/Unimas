package com.sripad.unimas.model.faculty;

public class Faculty {
    int faculty_id ;
    String fname;
    String joining_date;
    int dept_id ;
    String email;
    String phone ;
    Character gender ;
    int  salary ;
    int job_id;

    public Faculty() {
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "faculty_id=" + faculty_id +
                ", fname='" + fname + '\'' +
                ", joining_date='" + joining_date + '\'' +
                ", dept_id=" + dept_id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", job_id=" + job_id +
                '}';
    }

    public Faculty(int faculty_id, String fname, String joining_date, int dept_id, String email, String phone, Character gender, int salary, int job_id) {
        this.faculty_id = faculty_id;
        this.fname = fname;
        this.joining_date = joining_date;
        this.dept_id = dept_id;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
        this.job_id = job_id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
