package com.sripad.unimas.model;

public class OfferedCourses {
    int course_id ;
    String cname ,ctype;
    int dept_id ,  semno , CREDITS;

    @Override
    public String toString() {
        return "OfferedCourses{" +
                "course_id=" + course_id +
                ", cname='" + cname + '\'' +
                ", ctype='" + ctype + '\'' +
                ", dept_id=" + dept_id +
                ", semno=" + semno +
                ", CREDITS=" + CREDITS +
                '}';
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

    public int getCREDITS() {
        return CREDITS;
    }

    public void setCREDITS(int CREDITS) {
        this.CREDITS = CREDITS;
    }

    public OfferedCourses() {
    }
}
