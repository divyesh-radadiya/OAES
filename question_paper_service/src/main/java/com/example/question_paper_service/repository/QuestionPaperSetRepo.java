package com.example.question_paper_service.repository;

import com.example.question_paper_service.entity.QuestionPaperSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QuestionPaperSetRepo extends JpaRepository<QuestionPaperSet, Integer> {
    @Query(value = "SELECT * FROM question_paper_set where is_validate = 0 ", nativeQuery = true)
    List<QuestionPaperSet> getNotValidateQuestionPaperSet();

    QuestionPaperSet findBySetId(int setId);
}
