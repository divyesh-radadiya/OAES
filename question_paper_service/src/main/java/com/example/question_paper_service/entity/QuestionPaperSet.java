package com.example.question_paper_service.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionPaperSet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int setId;
    private int courseId;
    private int numberOfQuestionPaper=0;
    private int numberOfSection=0;
    private int totalMarks=0;
    private boolean isValidate=false;
    @JsonRawValue
    private String paperSet;



    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public int getCourseId() {
        return courseId;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean validate) {
        isValidate = validate;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getNumberOfQuestionPaper() {
        return numberOfQuestionPaper;
    }

    public void setNumberOfQuestionPaper(int numberOfQuestionPaper) {
        this.numberOfQuestionPaper = numberOfQuestionPaper;
    }

    public int getNumberOfSection() {
        return numberOfSection;
    }

    public void setNumberOfSection(int numberOfSection) {
        this.numberOfSection = numberOfSection;
    }

    public String getPaperSet() {
        return paperSet;
    }

    public void setPaperSet(String paperSet) {
        this.paperSet = paperSet;
    }
}
