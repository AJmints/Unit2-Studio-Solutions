package org.example;

import java.util.Objects;
import java.util.Scanner;

public class TrueFalse extends QuestionParent{

    private Boolean answer;

    public TrueFalse(String question, Boolean answer) {
        super(question);
        this.answer = answer;
    }

    public TrueFalse() {
    }

    public Boolean getAnswer() {
        return answer;
    }

    /** Instantiate scanner for TRUEFALSE makeTestQuestion method **/
    Scanner menuInput = new Scanner(System.in);

    public TrueFalse makeTestQuestion() {

        /** Create question **/
        System.out.println("\nWhat is the question you would like to ask?");
        String questionAnswer = menuInput.nextLine();

        System.out.println("\n'" + questionAnswer + "'\nIs this the question you want to ask? 1 for yes, 2 for no.");
        String confirm = menuInput.nextLine();

        /** This if block makes sure the user enters a valid response **/
        if (Objects.equals(confirm, "1")) {
            System.out.println("\nGreat!");
        } else if (Objects.equals(confirm, "2")) {
            System.out.println("\nYou selected 2, returning to the main menu\n");
            return null;
        } else {
            while (true) {
                System.out.println("\nPlease select 1 or 2");
                String input = menuInput.nextLine();

                if (Objects.equals(input, "1")) {
                    System.out.println("\nGreat!\n");
                    break;
                }
                if (Objects.equals(input, "2")) {
                    System.out.println("\nYou selected 2, returning to the main menu\n");
                    return null;
                }
            }
        }

        /** Store the question as true or false **/
        System.out.println("Is this question true or false?\n1 = true, 2 = false");
        String answer = menuInput.nextLine();
        Boolean finalAnswer = false;

        if (Objects.equals(answer, "1")) {
            System.out.println("\nSo your question is...\nQuestion: " + questionAnswer + "\nAnswer: True\n\nIs this correct? Press 1 for yes, 2 for no.");
            finalAnswer = true;
        }
        if (Objects.equals(answer, "2")) {
            System.out.println("So your question is...\nQuestion: " + questionAnswer + "\nAnswer: False\n\nIs this correct? Press 1 for yes, 2 for no.");
        }

        String setTestQuestion = menuInput.nextLine();

        if (Objects.equals(setTestQuestion, "1")) {
            System.out.println("\nAlright, your test has been added! Returning to the main menu...\n");
        }
        if (Objects.equals(setTestQuestion, "2")) {
            System.out.println("\nAlright, returning to main menu....");
            return null;
        }

        return new TrueFalse(questionAnswer, finalAnswer);
    }
}
