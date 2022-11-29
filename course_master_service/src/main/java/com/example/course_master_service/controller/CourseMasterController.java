package com.example.course_master_service.controller;

import com.example.course_master_service.entity.CourseMaster;
import com.example.course_master_service.service.CourseMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseMasterController {

    @Autowired
    private CourseMasterService courseMasterService;

    @RequestMapping(value = "/getCourse",method = RequestMethod.GET)
    public ResponseEntity<?> getCourse(){
        List<CourseMaster> courses = courseMasterService.getCourses();
        return ResponseEntity.ok(courses);
    }
}
