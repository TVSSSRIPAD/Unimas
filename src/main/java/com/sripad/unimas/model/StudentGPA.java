package com.sripad.unimas.model;

public class StudentGPA {
    String sroll;
    float gpa;
    int semno;

    public StudentGPA() {
    }

    public String getSroll() {
        return sroll;
    }

    public void setSroll(String sroll) {
        this.sroll = sroll;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getSemno() {
        return semno;
    }

    public void setSemno(int semno) {
        this.semno = semno;
    }

    @Override
    public String toString() {
        return "StudentGPA{" +
                "sroll='" + sroll + '\'' +
                ", gpa=" + gpa +
                ", semno=" + semno +
                '}';
    }

    public StudentGPA(String sroll, float gpa, int semno) {
        this.sroll = sroll;
        this.gpa = gpa;
        this.semno = semno;
    }

}
