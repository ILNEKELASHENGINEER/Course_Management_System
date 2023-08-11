package com.example.demo;

public class prd1 {
    String name,mobileno,dateofb,studentid;
    public prd1(String name, String mobileno, String dateofb, String studentid) {
        this.name = name;
        this.mobileno = mobileno;
        this.dateofb = dateofb;
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getDateofb() {
        return dateofb;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public void setDateofb(String dateofb) {
        this.dateofb = dateofb;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
}
