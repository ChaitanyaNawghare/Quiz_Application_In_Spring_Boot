package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll();
}
