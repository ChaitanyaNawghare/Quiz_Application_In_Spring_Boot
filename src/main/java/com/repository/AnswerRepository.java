package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
