package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class QuestionParent {

    private static int idCounter = 1;
    private Long id = 0L;
    private String question;



    public QuestionParent(String question) {
        this.id = (long) idCounter++;
        this.question = question;
    }

    public QuestionParent() {
    }



    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public static String removeBrackets(String clean) {
        String removedBrackets = clean.replaceAll("[\\[\\](){}]", "");
        return removedBrackets;
    }

    public abstract QuestionParent makeTestQuestion();

}
