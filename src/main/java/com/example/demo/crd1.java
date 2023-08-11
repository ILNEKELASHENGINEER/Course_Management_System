package com.example.demo;

public class crd1 {
    String coursename,courseid,facultyname,studentid;

    public crd1(String coursename, String courseid, String facultyname, String studentid) {
        this.coursename = coursename;
        this.courseid = courseid;
        this.facultyname = facultyname;
        this.studentid = studentid;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getCourseid() {
        return courseid;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
}
