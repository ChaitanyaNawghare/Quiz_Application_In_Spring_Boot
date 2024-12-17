package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Answer;
import com.model.Question;
import com.model.User;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.UserRepository;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	public User startNewQuiz(String userName) {
		User user = userRepository.findByName(userName);
		if (user == null) {
			user = new User();
			user.setName(userName);
			userRepository.save(user);
		}
		return user;
	}

	public Question getRandomQuestion() {
		List<Question> questions = questionRepository.findAll();
		Random random = new Random();
		return questions.get(random.nextInt(questions.size()));
	}

	public Answer submitAnswer(Long userId, Long questionId, String answer) {
		User user = userRepository.findById(userId).orElseThrow();
		Question question = questionRepository.findById(questionId).orElseThrow();
		Answer answerObj = new Answer();
		answerObj.setUser(user);
		answerObj.setQuestion(question);
		answerObj.setSelectedAnswer(answer);
		answerObj.setCorrect(answer.equals(question.getCorrectAnswer()));
		return answerRepository.save(answerObj);
	}

	public List<Answer> getQuizResults(Long userId) {
		return answerRepository.findAll();
	}
}
