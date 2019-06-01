package com.lobuz.game.dto.service;

import com.lobuz.game.dto.entity.QuestionModel;
import com.lobuz.game.dto.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<QuestionModel> getQuestions() {
        return repository.findAll();
    }


}
