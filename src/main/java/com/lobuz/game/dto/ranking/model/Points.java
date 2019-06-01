package com.lobuz.game.dto.ranking.model;

import com.lobuz.game.dto.entity.QuestionModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

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
        }
    }
}
