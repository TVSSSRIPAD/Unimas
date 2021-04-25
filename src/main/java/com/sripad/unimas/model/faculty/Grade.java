package com.sripad.unimas.model.faculty;

public class Grade {

    String sroll;
    int course_id;
    int grade;

    public Grade() {
    }

    public Grade(String sroll, int course_id, int grade) {
        this.sroll = sroll;
        this.course_id = course_id;
        this.grade = grade;
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
