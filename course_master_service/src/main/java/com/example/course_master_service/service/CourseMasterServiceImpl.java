package com.example.course_master_service.service;

import com.example.course_master_service.entity.CourseMaster;
import com.example.course_master_service.repository.CourseMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMasterServiceImpl implements CourseMasterService {

    @Autowired
    private CourseMasterRepo courseMasterRepo;

    public List<CourseMaster> getCourses()
    {
        List<CourseMaster> courses = courseMasterRepo.findAll();
        return courses;
    }

}
