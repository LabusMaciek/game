package com.lobuz.game.dto.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Getter
@Setter
@Service
public class Points {

    private int points = 0;
    private final List<QuestionModel> questions;

    public Points(List<QuestionModel> questions) {
        this.questions = questions;
    }


    public void calculatePoints(String answer, int num) {
        if (answer.equals(questions.get(num).getAnswerD())) {
            points++;
            log.info("points" + points);
        }
    }
}
