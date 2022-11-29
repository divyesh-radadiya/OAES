package com.example.question_paper_service.service;


import com.example.question_paper_service.entity.QuestionPaperSet;

import java.util.List;
import java.util.Map;

public interface QuestionPaperService {
    public QuestionPaperSet generatePaperSet(Map<String,Object> payload);

    public String generateSection(Map<String,Object> section,int courseId);

    public List<QuestionPaperSet> getNonValidateQuestionPaperSet();

    public void validateQuestionPaperSet(Map<String,String> payload);

}

