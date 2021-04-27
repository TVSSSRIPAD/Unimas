package com.sripad.unimas.model.faculty;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
    List<Integer> cids = new ArrayList<>();

    @Override
    public String toString() {
        return "CourseList{" +
                "cids=" + cids +
                '}';
    }

    public List<Integer> getCids() {
        return cids;
    }

    public void setCids(List<Integer> cids) {
        this.cids = cids;
    }

    public CourseList() {
    }

    public CourseList(List<Integer> cids) {
        this.cids = cids;
    }
}
