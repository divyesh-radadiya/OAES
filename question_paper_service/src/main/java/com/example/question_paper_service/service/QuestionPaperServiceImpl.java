package com.example.question_paper_service.service;


import com.example.question_paper_service.entity.Item;
import com.example.question_paper_service.entity.QuestionPaperSet;
import com.example.question_paper_service.repository.QuestionPaperSetRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service(value = "questionPaperService")
public class QuestionPaperServiceImpl  implements QuestionPaperService {

    @Autowired
    private QuestionPaperSetRepo questionPaperSetRepo;

    @Autowired
    private RestTemplate restTemplate;

    public QuestionPaperSet generatePaperSet(Map<String,Object> payload){
        QuestionPaperSet questionPaperSet = new QuestionPaperSet();
        int courseId = Integer.parseInt((String)payload.get("courseId"));
        int numberOfQuestionPaper = Integer.parseInt((String)payload.get("numberOfQuestionPaper"));
        Map<String,Object> testPattern = (Map<String,Object>) payload.get("testPattern");
        int numberOfSection = Integer.parseInt((String) testPattern.get("numberOfSection"));
        int totalMarks = Integer.parseInt((String) testPattern.get("totalMarks"));

        questionPaperSet.setCourseId(courseId);
        questionPaperSet.setNumberOfQuestionPaper(numberOfQuestionPaper);
        questionPaperSet.setNumberOfSection(numberOfSection);
        questionPaperSet.setTotalMarks(totalMarks);

        String paperSet = "{";
        for(int i=1;i<=numberOfQuestionPaper;i++)
        {
            if(i!=1) paperSet+=",";
            paperSet+="\"" + Integer.toString(i) + "\": {";
            for(int j=1;j<=numberOfSection;j++)
            {
                if(j!=1) paperSet+=",";
                Map<String,Object> sectionPattern = (Map<String,Object>) testPattern.get(Integer.toString(j));
                paperSet+="\"" + Integer.toString(j) + "\": {";
                paperSet+="\"questionType\": \"" +(String) sectionPattern.get("questionType") + "\",";
                paperSet+="\"sectionMarks\": \"" +(String) sectionPattern.get("sectionMarks") + "\",";
                paperSet+="\"numberOfQuestion\": \"" +(String) sectionPattern.get("numberOfQuestion") + "\",";
                paperSet+="\"numberOfQuestionAttempt\": \"" +(String) sectionPattern.get("numberOfQuestionAttempt") + "\",";
                paperSet+="\"questions\": [";
                paperSet+=generateSection(sectionPattern,courseId);
                paperSet+="]}";
            }
            paperSet+="}";
        }
        paperSet+="}";
        questionPaperSet.setPaperSet(paperSet);
        questionPaperSet = questionPaperSetRepo.save(questionPaperSet);
        return questionPaperSet;
    }

    public String generateSection(Map<String,Object> section,int courseId)
    {
        String questionType = (String) section.get("questionType");
        String numberOfQuestion = ((String) section.get("numberOfQuestion"));

        JSONObject request = new JSONObject();
        request.put("questionType",questionType);
        request.put("numberOfQuestion", numberOfQuestion);
        request.put("courseId", Integer.toString(courseId));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        System.out.println("****");

        List<Map<String ,Object >> responseEntity=  this.restTemplate.postForObject("http://item-service/item/getRandomItem",entity,List.class);

        System.out.println(responseEntity.get(0));
        System.out.println(responseEntity.get(0).get("itemId"));

//        JSONObject jsonObject = new JSONObject(responseEntity.get(0).toString());
//        System.out.println(jsonObject.toString());
//
//        List<Item> items = (List<Item>) responseEntity.get(0);

//        System.out.println(((Item)(responseEntity.get(0))).getItemId());

        String questions = "";
        for(int i=1;i<=responseEntity.size();i++)
        {
            if(i!=1) questions+=",";
            questions+=responseEntity.get(i-1).get("itemId");
        }
        return questions;
    }

    public List<QuestionPaperSet> getNonValidateQuestionPaperSet()
    {
        List<QuestionPaperSet> questionPaperSets = questionPaperSetRepo.getNotValidateQuestionPaperSet();
        return questionPaperSets;
    }

    public void validateQuestionPaperSet(Map<String,String> payload)
    {
        int questionPaperSetId = Integer.parseInt(payload.get("setId"));
        QuestionPaperSet questionPaperSet = questionPaperSetRepo.findBySetId(questionPaperSetId);
        questionPaperSet.setValidate(true);
        questionPaperSetRepo.save(questionPaperSet);
    }
}
