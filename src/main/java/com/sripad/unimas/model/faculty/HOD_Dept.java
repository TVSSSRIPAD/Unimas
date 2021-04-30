package com.sripad.unimas.model.faculty;

public class HOD_Dept {
    int fid;
    int dept;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public HOD_Dept() {
    }

    public HOD_Dept(int fid, int dept) {
        this.fid = fid;
        this.dept = dept;
    }
}
