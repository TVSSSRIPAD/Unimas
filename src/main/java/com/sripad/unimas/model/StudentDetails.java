package com.sripad.unimas.model;

import java.util.List;

public class StudentDetails {
    List<RegisteredCourses> coursesList  ;

    List<StudentGrades> sgrades  ;
    List<StudentGPA> sgpa  ;

    public StudentDetails(List<RegisteredCourses> coursesList, List<StudentGrades> sgrades, List<StudentGPA> sgpa) {
        this.coursesList = coursesList;
        this.sgrades = sgrades;
        this.sgpa = sgpa;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "coursesList=" + coursesList +
                ", sgrades=" + sgrades +
                ", sgpa=" + sgpa +
                '}';
    }

    public List<RegisteredCourses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<RegisteredCourses> coursesList) {
        this.coursesList = coursesList;
    }

    public List<StudentGrades> getSgrades() {
        return sgrades;
    }

    public void setSgrades(List<StudentGrades> sgrades) {
        this.sgrades = sgrades;
    }

    public List<StudentGPA> getSgpa() {
        return sgpa;
    }

    public void setSgpa(List<StudentGPA> sgpa) {
        this.sgpa = sgpa;
    }
}
