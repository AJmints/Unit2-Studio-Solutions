package org.example;

import java.util.*;

public class CheckBox extends QuestionParent {

    List<HashMap<Boolean, String>> answers = new ArrayList<>();

    public CheckBox(String question, List<HashMap<Boolean, String>> answers) {
        super(question);
        this.answers = answers;
    }

    public CheckBox() {
    }

    public List<HashMap<Boolean, String>> getAnswers() {
        return answers;
    }

    public void setAnswers(List<HashMap<Boolean, String>> answers) {
        this.answers = answers;
    }

    /** We need to instantiate a Scanner object in the class **/
    Scanner menuInput = new Scanner(System.in);

    /** Make a multiple choice question **/
    /** Make a multiple choice question **/
    /** Make a multiple choice question **/
    public CheckBox makeTestQuestion() {
        /** Create question **/
        System.out.println("\nWhat is the question you would like to ask?");
        String questionAnswer = menuInput.nextLine();

        System.out.println("\n'" + questionAnswer + "'\nIs this the question you want to ask? 1 for yes, 2 for no.");
        String confirm = menuInput.nextLine();

        /** This if block makes sure the user enters a valid response **/
        if (Objects.equals(confirm, "1")) {
            System.out.println("\nGreat! Let's start making some answers!");
        } else if (Objects.equals(confirm, "2")) {
            System.out.println("\nYou selected 2, returning to the main menu\n");
            return null;
        } else {
            while (true) {
                System.out.println("\nPlease select 1 or 2");
                String input = menuInput.nextLine();

                if (Objects.equals(input, "1")) {
                    System.out.println("\nGreat! Let's start making some answers! We need a minimum of 3 answers, or a maximum of 8.\n");
                    break;
                }
                if (Objects.equals(input, "2")) {
                    System.out.println("\nYou selected 2, returning to the main menu\n");
                    return null;
                }
            }
        }

        /** List to store our answers **/
        List<HashMap<Boolean, String>> answerList = new ArrayList<>();

        /** Create answers to question with while true loop **/
        while (true) {
            if (answerList.size() < 3) {
                System.out.println("Select 3 at any time to view all your answers\nPlease enter an answer for...\n'" + questionAnswer + "'\n");
            } else if (answerList.size() < 8) {
                System.out.println("Select 3 at any time to view all your answers\nSelect 4 to save your current list\nSelect 0 to cancel and return to main menu\nPlease enter an answer for...\n'" + questionAnswer + "'");
            } else if (answerList.size() == 8) {
                break;
            }

            String answerText = menuInput.nextLine();

            if (Objects.equals(answerText, "3")) {
                Integer count = 1;
                System.out.println();
                for (HashMap<Boolean, String> answers : answerList) {
                    System.out.println(count + ". Answer: " + answers.values() + "\n" + count + ". Is this answer correct: " + answers.keySet());
                    count++;
                }
                System.out.println();
                // Restart the while true loop from here
                continue;
            }
            if (Objects.equals(answerText, "4") && answerList.size() >= 3) {
                // Break out of the while true loop
                break;
            }
            if (Objects.equals(answerText, "0")) {
                return null;
            }

            boolean answerStatus = false;
            System.out.println("\nIs this a correct answer to the question?\n1 for yes, 2 for no.");
            String response = menuInput.nextLine();
            if (Objects.equals(response, "1")) {
                answerStatus = true;
            } else if (Objects.equals(response, "2")) {
                answerStatus = false;
            }

            System.out.println("\nAlright so this answer is: " + (answerStatus ? "True" : "False") + "\nThe answer you wrote is: " + answerText + "\n\nIf this is correct, select 1 for yes, 2 for no.");

            String input = menuInput.nextLine();

            if (Objects.equals(input, "1")) {
                System.out.println("\nThis answer has been saved.\n");
                HashMap<Boolean, String> answer = new HashMap<>();
                answer.put(answerStatus, answerText);
                answerList.add(answer);
            }
            if (Objects.equals(input, "2")) {
                System.out.println("\nThis answer hasn't been saved.");
            }
            if (Objects.equals(input, "0")) {
                System.out.println("\nReturning to main menu....");
                return null;
            }
        }

        System.out.println("\nYou have created your test question, would you like to save it? 1 for yes, 2 for no.");
        String saveAsTestQuestion = menuInput.nextLine();

        if (Objects.equals(saveAsTestQuestion, "1")){
            System.out.println("\nThis answer has been saved, returning to the main menu.");
        } else if (Objects.equals(saveAsTestQuestion, "2")) {
            System.out.println("\nYou selected 2, returning to the main menu\n");
            return null;
        }  else {
            System.out.println("\nInvalid selection.");
            while (true) {
                System.out.println("\nPlease select 1 or 2");
                String input = menuInput.nextLine();

                if (Objects.equals(input, "1")) {
                    break;
                }
                if (Objects.equals(input, "2")) {
                    System.out.println("\nYou selected 2, returning to the main menu\n");
                    return null;
                }
            }
        }

        return new CheckBox(questionAnswer, answerList);

    }
}
