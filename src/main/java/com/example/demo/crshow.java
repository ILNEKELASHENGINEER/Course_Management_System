package com.example.demo;

public class crshow {
    String coursename,courseid,facultyname;

    public crshow(String coursename, String courseid, String facultyname) {
        this.coursename = coursename;
        this.courseid = courseid;
        this.facultyname = facultyname;
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

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }
}
