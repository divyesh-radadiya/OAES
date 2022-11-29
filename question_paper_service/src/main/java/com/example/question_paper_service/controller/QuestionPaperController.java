package com.example.question_paper_service.controller;

import com.example.question_paper_service.entity.QuestionPaperSet;
import com.example.question_paper_service.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questionpaper")
public class QuestionPaperController {

    @Autowired
    private QuestionPaperService questionPaperService;

    @RequestMapping(value = "/generatePaperSet", method = RequestMethod.POST)
    public ResponseEntity<?> generatePaperSet(@RequestBody Map<String,Object> payload)
    {
        QuestionPaperSet questionPaperSet = questionPaperService.generatePaperSet(payload);
        return ResponseEntity.ok(questionPaperSet);
    }

    @RequestMapping(value = "/nonValidateQuestionPaperSet", method = RequestMethod.GET)
    public ResponseEntity<?> nonValidateQuestionPaperSet()
    {
        List<QuestionPaperSet> questionPaperSets = questionPaperService.getNonValidateQuestionPaperSet();
        return ResponseEntity.ok(questionPaperSets);
    }

    @RequestMapping(value = "/ValidateQuestionPaperSet", method = RequestMethod.POST)
    public ResponseEntity<?> validateQuestionPaperSet(@RequestBody Map<String,String> payload)
    {
        questionPaperService.validateQuestionPaperSet(payload);
        return ResponseEntity.ok(true);
    }
}
