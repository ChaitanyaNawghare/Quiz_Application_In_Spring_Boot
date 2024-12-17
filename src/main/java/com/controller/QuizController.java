package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.model.Answer;
import com.model.Question;
import com.model.User;
import com.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/start")
	public User startQuiz(@RequestParam String userName) {
		return quizService.startNewQuiz(userName);
	}

	@GetMapping("/question")
	public Question getRandomQuestion() {
		return quizService.getRandomQuestion();
	}

	@PostMapping("/submit")
	public Answer submitAnswer(@RequestParam Long userId, @RequestParam Long questionId, @RequestParam String answer) {
		return quizService.submitAnswer(userId, questionId, answer);
	}

	@GetMapping("/results")
	public List<Answer> getQuizResults(@RequestParam Long userId) {
		return quizService.getQuizResults(userId);
	}
}
