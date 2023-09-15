package org.example;

import java.util.*;

public class Main {

    /** Feel free to fork this code and modify it however you want. **/
    /** Feel free to fork this code and modify it however you want. **/
    /** Feel free to fork this code and modify it however you want. **/

    /** Input and Storage **/
    private static final Scanner mainMenuInput = new Scanner(System.in);
    public static List<QuestionParent> allTestQuestions = new ArrayList<>();
    public static List<TestEntity> allTests = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Let's make a quiz application!\n");

        while (true) {
            /** Root Prompt **/
            /** Root Prompt **/
            System.out.println("Please Select\n1. Make a Test Question\n2. Create Default Test\n3. View all Test Questions\n4. Take a test\n5. Make your own Test\n6. View all Test\n0. Exit App");

            String choice = mainMenuInput.nextLine();

            /** 1. Make a Test Question **/
            if (Objects.equals(choice, "1")) {

                System.out.println("\nWhat type of question would you like to write?\n1. CheckBox\n2. MultipleChoice\n3. True/False\n0. Return to main menu");
                choice = mainMenuInput.nextLine();

                /** Make CheckBox Style Question **/
                if (Objects.equals(choice, "1")) {
                    Optional<CheckBox> checkBox = Optional.of(new CheckBox().makeTestQuestion());
                    checkBox.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                /** Make MultipleChoice Style Question **/
                if (Objects.equals(choice, "2")) {
                    Optional<MultipleChoice> multipleChoice = Optional.of(new MultipleChoice().makeTestQuestion());
                    multipleChoice.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                /** Make TrueFalse Style Question **/
                if (Objects.equals(choice, "3")) {
                    Optional<TrueFalse> trueFalse = Optional.of(new TrueFalse().makeTestQuestion());
                    trueFalse.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                if (Objects.equals(choice, "0")) {
                    continue;
                }
            }

            /** 2. Create a Default Test **/
            if ( Objects.equals(choice, "2")) {
                System.out.println("Preparing default test, press 1 to proceed, or 2 to cancel");
                choice = mainMenuInput.nextLine();

                if (Objects.equals(choice, "1")) {
                    TestEntity defaultTest = TestEntity.createDefaultTest();
                    allTests.add(defaultTest);
                    allTestQuestions.addAll(defaultTest.getQuestions());
                    System.out.println("LaunchCode 101, Unit 2 Java - has been added to your available tests\n");
                }
                if (Objects.equals(choice, "2")) {
                    System.out.println("Default test canceled, returning to main menu");
                    continue;
                }
            }

            /** 3. View all Test Questions **/
            if (Objects.equals(choice, "3")) {
                System.out.println();
                for (QuestionParent questions : allTestQuestions) {
                    System.out.println(questions.getId() + ". " + questions.getQuestion());
                }
                System.out.println();
                continue;
            }

            /** 4. Take a test **/
            if (Objects.equals(choice, "4")) {
                takeATest();
                continue;
            }

            /** 5. Make your own Test **/
            if (Objects.equals(choice, "5")) {
                System.out.println("\nThis option isn't ready yet...Returning to main menu\n");
                continue;
            }

            /** 6. View all Test **/
            if (Objects.equals(choice, "6")) {
                System.out.println("\nThis option isn't ready yet...Returning to main menu\n");
                continue;
            }

            if (Objects.equals(choice, "0")) {
                System.out.println("\nApp is terminating\n......\n.....\n...\n..\n.\n.");
                return;
            }
        }
    }

    public static void takeATest() {
        System.out.println("\nAlright, lets take a test! Which test would you like to take.\nType the ID of the test to take it.");
        Long testId = 0L;
        TestEntity gradeTestEntity = new TestEntity();

        System.out.println();
        for (TestEntity test : allTests) {
            testId = test.getId();
            System.out.println("ID: " + test.getId() + ". " + test.getName());
            gradeTestEntity = test;
        }
        System.out.println();

        String takeThisTest = mainMenuInput.nextLine();
        TestEntity testToTake = new TestEntity();

        for (TestEntity test : allTests) {
            if (Objects.equals(test.getId().toString(),  takeThisTest)) {
                testToTake = test;
            }
        }

        System.out.println("You have selected the test: \n" + testToTake.getName() + "\n\nLoading questions...");

        // Save the answer the user input and count the correct answers in the end.
        List<HashMap<Boolean, String>> selectedA = new ArrayList<>();

        for (QuestionParent question : testToTake.getQuestions()) {
            System.out.println("\n" + question.getQuestion());

            /** Display the answers for MULTIPLECHOICE questions **/
            if (question.getClass() == MultipleChoice.class) {
                int id = 1;
                for (HashMap<Boolean, String> answers : ((MultipleChoice) question).getAnswers()) {
                    System.out.println(id + "." + answers.values());
                    id++;
                }

                System.out.println("\nWhich number has the correct answer?");
                String answer = mainMenuInput.nextLine();

                /** Find the users response and store the string to compare later **/
                Integer idCheck = 1;
                for (HashMap<Boolean, String> answers : ((MultipleChoice) question).getAnswers()) {
                    if (idCheck.toString().equals(answer)) {
                        selectedA.add(answers);
                    }
                    idCheck++;
                }
            }
            /** Display the answers for TRUEFALSE questions **/
            if (question.getClass() == TrueFalse.class) {
                System.out.println("1.True\n2.False\n");

                System.out.println("Which number has the correct answer?");
                String answer = mainMenuInput.nextLine();
                Boolean response = false;
                if (Objects.equals(answer, "1")) {
                    response = true;
                }

                /** Save the answers **/
                if (((TrueFalse) question).getAnswer() == response) {
                    HashMap<Boolean, String> trueFalse = new HashMap<>();
                    trueFalse.put(response, "Correct");
                    selectedA.add(trueFalse);
                } else {
                    HashMap<Boolean, String> trueFalse = new HashMap<>();
                    trueFalse.put(response, "Incorrect");
                    selectedA.add(trueFalse);
                }

            }
            /** Display the answers for CHECKBOX questions **/
            if (question.getClass() == CheckBox.class) {
                int id = 1;
                for (HashMap<Boolean, String> answers : ((CheckBox) question).getAnswers()) {
                    System.out.println(id + "." + answers.values());
                    id++;
                }

                ArrayList<String> checkBoxResponses = new ArrayList<>();
                System.out.println("\nWhich number has the correct answer?\nEnter each answer 1 at a time, press 0 when finished answering the question.");
                while (true) {
                    String answer = mainMenuInput.nextLine();
                    if (Objects.equals(answer, "0")) {
                        break;
                    }
                    checkBoxResponses.add(answer);
                    System.out.println("Enter another answer?");
                }

                /** Find the users response and store the string to compare later **/
                Integer idCheck = 1;
                for (HashMap<Boolean, String> answers : ((CheckBox) question).getAnswers()) {
                    for (String inputs : checkBoxResponses) {
                        if (idCheck.toString().equals(inputs)) {
                            selectedA.add(answers);
                        }
                    }
                    idCheck++;
                }

            }
        }

        /** Grade Test **/
        TestEntity.gradeTest(selectedA, gradeTestEntity);

    }

}
