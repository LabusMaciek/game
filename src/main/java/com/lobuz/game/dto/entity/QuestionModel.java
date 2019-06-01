package com.lobuz.game.dto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
@Entity
public class QuestionModel {


    @Id
    @GeneratedValue
    private long id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
//private List<Answers> answers;



}
