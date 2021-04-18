package com.sripad.unimas.model;

public class StudentGrades {
    String sroll;
    String cname;
    int grade;
    int semno;

    public StudentGrades() {
    }

    public StudentGrades(String sroll, String cname, int grade, int semno) {
        this.sroll = sroll;
        this.cname = cname;
        this.grade = grade;
        this.semno = semno;
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
