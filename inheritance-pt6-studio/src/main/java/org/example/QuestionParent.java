package org.example;

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

    /** Use regex to remove brackets from strings **/
    public static String removeBrackets(String clean) {
        return clean.replaceAll("[\\[\\](){}]", "");
    }

    /** Require all children of QuestionParent to use this method **/
    public abstract QuestionParent makeTestQuestion();

}
