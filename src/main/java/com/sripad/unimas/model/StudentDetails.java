package com.sripad.unimas.model;

import java.util.List;

public class StudentDetails {


    List<StudentGrades> sgrades  ;
    List<StudentGPA> sgpa  ;

    public StudentDetails(  List<StudentGrades> sgrades, List<StudentGPA> sgpa) {

        this.sgrades = sgrades;
        this.sgpa = sgpa;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +

                ", sgrades=" + sgrades +
                ", sgpa=" + sgpa +
                '}';
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
