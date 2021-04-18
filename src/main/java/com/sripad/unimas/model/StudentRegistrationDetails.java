package com.sripad.unimas.model;

import java.util.List;

public class StudentRegistrationDetails {
    List<RegisteredCourses> coursesList;
    boolean registered  ;
    List<OfferedCourses> offeredCourses;

    public StudentRegistrationDetails() {
    }

    public StudentRegistrationDetails(List<RegisteredCourses> coursesList, boolean registered, List<OfferedCourses> offeredCourses) {
        this.coursesList = coursesList;
        this.registered = registered;
        this.offeredCourses = offeredCourses;
    }

    public List<RegisteredCourses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<RegisteredCourses> coursesList) {
        this.coursesList = coursesList;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public List<OfferedCourses> getOfferedCourses() {
        return offeredCourses;
    }

    public void setOfferedCourses(List<OfferedCourses> offeredCourses) {
        this.offeredCourses = offeredCourses;
    }
}
