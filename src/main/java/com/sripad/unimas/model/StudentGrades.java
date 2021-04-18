package com.sripad.unimas.model;

public class StudentGrades {
    String sroll;
    String cname, ctype;
    int grade;
    int semno, credits;


    public StudentGrades(String sroll, String cname, String ctype, int grade, int semno, int credits) {
        this.sroll = sroll;
        this.cname = cname;
        this.ctype = ctype;
        this.grade = grade;
        this.semno = semno;
        this.credits = credits;
    }


    public StudentGrades() {
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSroll() {
        return sroll;
    }

    public void setSroll(String sroll) {
        this.sroll = sroll;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSemno() {
        return semno;
    }

    public void setSemno(int semno) {
        this.semno = semno;
    }
}
