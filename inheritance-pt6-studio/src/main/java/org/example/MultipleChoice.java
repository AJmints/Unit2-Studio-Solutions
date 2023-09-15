package org.example;

import java.util.*;

public class MultipleChoice extends QuestionParent{

    List<HashMap<Boolean, String>> answers = new ArrayList<>();

    public MultipleChoice(String question, List<HashMap<Boolean, String>> answers) {
        super(question);
        this.answers = answers;
    }

    public MultipleChoice() {
    }

    public List<HashMap<Boolean, String>> getAnswers() {
        return answers;
    }

    public void setAnswers(List<HashMap<Boolean, String>> answers) {
        this.answers = answers;
    }

    /** We need to instantiate a Scanner object in the class **/
    Scanner menuInput = new Scanner(System.in);

    public MultipleChoice makeTestQuestion() {

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
            System.out.println("Enter 1 correct answer, and 3 incorrect answers\nPlease enter 4 answers for...\n'" + questionAnswer + "'\n\nFirst Answer:");
            String answerA = menuInput.nextLine();

            System.out.println("\nSecond Answer:");
            String answerB = menuInput.nextLine();

            System.out.println("\nThird Answer:");
            String answerC = menuInput.nextLine();

            System.out.println("\nFourth Answer:");
            String answerD = menuInput.nextLine();

            System.out.println("\nWhich answer is the correct answer? (Select 0 to restart)\n1. " + answerA + "\n2. " + answerB + "\n3. " + answerC + "\n4. " + answerD);

            String correctAnswer = menuInput.nextLine();
            if (Objects.equals(correctAnswer, "0")) {
                System.out.println("\nRestarting...\n");
                continue;
            }

            HashMap<Boolean, String> aA = new HashMap<>();
            aA.put(false, answerA);
            HashMap<Boolean, String> aB = new HashMap<>();
            aA.put(false, answerB);
            HashMap<Boolean, String> aC = new HashMap<>();
            aA.put(false, answerC);
            HashMap<Boolean, String> aD = new HashMap<>();
            aA.put(false, answerD);

            if (Objects.equals(correctAnswer.toLowerCase(), "1")) {
                aA = new HashMap<>();
                aA.put(true, answerA);
            } else if (Objects.equals(correctAnswer.toLowerCase(), "2")) {
                aB = new HashMap<>();
                aB.put(true, answerB);
            } else if (Objects.equals(correctAnswer.toLowerCase(), "3")) {
                aC = new HashMap<>();
                aC.put(true, answerC);
            } else if (Objects.equals(correctAnswer.toLowerCase(), "4")) {
                aD = new HashMap<>();
                aD.put(true, answerD);
            }

            answerList.add(aA);
            answerList.add(aB);
            answerList.add(aC);
            answerList.add(aD);

            break;

        }

        System.out.println("\nQuestion: " + questionAnswer + "\nYou have created your test question, would you like to save it? 1 for yes, 2 for no.");
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

        return new MultipleChoice(questionAnswer, answerList);
    }

}
