package com.sripad.unimas.model.faculty;

public class Attend {
    String sroll;
    int course_id;
    String adate;
    Character status;


    public Attend() {
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

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Attend(String sroll, int course_id, String adate, Character status) {
        this.sroll = sroll;
        this.course_id = course_id;
        this.adate = adate;
        this.status = status;
    }
}
