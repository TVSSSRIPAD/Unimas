package com.sripad.unimas.model;

public class RegisteredCourses {
    String sroll;
    int course_id;
    String cname;

    public RegisteredCourses() {
    }

    String  ctype;
    int dept_id;
    int semno, credits;

    public String getSroll() {
        return sroll;
    }

    public void setSroll(String sroll) {
        this.sroll = sroll;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getSemno() {
        return semno;
    }

    public void setSemno(int semno) {
        this.semno = semno;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }



}
