package com.example.course_master_service.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.json.JSONObject;

@Entity
public class CourseMaster {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private String courseDescription;
    @JsonRawValue
    private String testPattern;

    public CourseMaster() {
    }

    public CourseMaster(int courseId, String courseName, String courseDescription, String  testPattern) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.testPattern = testPattern;

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getTestPattern() {
        return testPattern;
    }

    public void setTestPattern(String testPattern) {
        this.testPattern = testPattern;
    }



}
