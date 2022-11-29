package com.example.course_master_service.repository;

import com.example.course_master_service.entity.CourseMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMasterRepo  extends JpaRepository<CourseMaster, Integer> {
    public List<CourseMaster> findAll();
}
