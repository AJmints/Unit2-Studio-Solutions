package org.example;

import java.util.*;

public class Main {

    /** Feel free to fork this code and modify it however you want. **/
    /** Feel free to fork this code and modify it however you want. **/
    /** Anything Marked with TODO is a side quest for you if you choose to try it **/

    /** Input and Storage **/
    private static final Scanner mainMenuInput = new Scanner(System.in);
    public static List<QuestionParent> allTestQuestions = new ArrayList<>();
    public static List<TestEntity> allTests = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Let's make a quiz application!\n");

        while (true) {

            /** Root Prompt **/
            System.out.println("Please Select\n1. Make a Test Question\n2. Create Default Test\n3. View all Test Questions\n4. Take a test\n5. Make your own Test\n6. View all Test\n0. Exit App");

            String choice = mainMenuInput.nextLine();

            /** 1. Make a Test Question **/
            if (Objects.equals(choice, "1")) {

                System.out.println("\nWhat type of question would you like to write?\n1. CheckBox\n2. MultipleChoice\n3. True/False\n0. Return to main menu");
                choice = mainMenuInput.nextLine();

                /** Make CheckBox Style Question **/
                // Create a new CheckBox class, then call the makeTestQuestion method
                // Optional is a very useful method, we will go over it in the curriculum later on, but feel free to look into it now.
                if (Objects.equals(choice, "1")) {
                    Optional<CheckBox> checkBox = Optional.of(new CheckBox().makeTestQuestion());
                    // If our CheckBox item was made, add it to the list, else, skip this step and return to main menu.
                    checkBox.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                /** Make MultipleChoice Style Question **/
                // Create a new MultipleChoice class, then call the makeTestQuestion method
                // Optional is a very useful method, we will go over it in the curriculum later on, but feel free to look into it now.
                if (Objects.equals(choice, "2")) {
                    Optional<MultipleChoice> multipleChoice = Optional.of(new MultipleChoice().makeTestQuestion());
                    // If our MultipleChoice item was made, add it to the list, else, skip this step and return to main menu.
                    multipleChoice.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                /** Make TrueFalse Style Question **/
                // Create a new TrueFalse class, then call the makeTestQuestion method
                // Optional is a very useful method, we will go over it in the curriculum later on, but feel free to look into it now.
                if (Objects.equals(choice, "3")) {
                    Optional<TrueFalse> trueFalse = Optional.of(new TrueFalse().makeTestQuestion());
                    // If our TrueFalse item was made, add it to the list, else, skip this step and return to main menu.
                    trueFalse.ifPresent(value -> allTestQuestions.add(value));
                    continue;
                }
                if (Objects.equals(choice, "0")) {
                    // Return to main menu
                    continue;
                }
            }

            /** 2. Create a Default Test **/
            if ( Objects.equals(choice, "2")) {
                System.out.println("\nPreparing default test, press 1 to proceed, or 2 to cancel");
                choice = mainMenuInput.nextLine();

                /** Create a TestEntity Object, then use the static method createDefaultTest to instantiate the new TestEntity
                 * add the default test to allTests List
                 * add all the generated test questions to the allTestQuestions List**/
                if (Objects.equals(choice, "1")) {
                    TestEntity defaultTest = TestEntity.createDefaultTest();
                    allTests.add(defaultTest);
                    /** TODO: Make sure we don't save duplicate test questions in the allTestQuestions **/
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
                // Display the test question ID and the test question Name
                for (QuestionParent questions : allTestQuestions) {
                    System.out.println(questions.getId() + ". " + questions.getQuestion());
                }
                System.out.println();
                continue;
            }

            /** 4. Take a test **/
            if (Objects.equals(choice, "4")) {
                /** Take the test that you select **/
                takeATest(); // Located in Main
                continue;
            }

            /** 5. Make your own Test **/
            if (Objects.equals(choice, "5")) {
                /** TODO: If you want to create the method (makeYourOwnTest), you are welcome to give it a shot!
                 * The requirements are...
                 * Take test answers from the allTestQuestions List you want to include in your test and store them in a new List
                 * Take that new list, and instantiate a new TestEntity Class
                 * Save the new Test to the allTest List in Main**/
                // Consider: Where is the best place to store this new method? What is being returned from the methods you create?
                System.out.println("\nThis option isn't ready yet...Returning to main menu\n");
                continue;
            }

            /** 6. View all Test **/
            if (Objects.equals(choice, "6")) {
                System.out.println();
                /** Iterate through the allTests list and display each testId and testName **/
                for (TestEntity test : allTests) {
                    System.out.println(test.getId() + ": " + test.getName());
                }
                System.out.println();
                continue;
            }

            if (Objects.equals(choice, "0")) {
                System.out.println("\nApp is terminating\n......\n.....\n...\n..\n.\n.");
                return;
            }
        }
    }

    /** This method handles the user selecting a test they want to take and running it **/
    /** This method handles the user selecting a test they want to take and running it **/
    /** This method handles the user selecting a test they want to take and running it **/
    public static void takeATest() {
        System.out.println("\nAlright, lets take a test! Which test would you like to take.\nType the ID of the test to take it.");
        TestEntity gradeTestEntity = new TestEntity();

        /** Select the test you want to take **/
        System.out.println();
        for (TestEntity test : allTests) {
            System.out.println("ID: " + test.getId() + ". " + test.getName());
            gradeTestEntity = test;
        }
        System.out.println();

        String takeThisTest = mainMenuInput.nextLine();
        TestEntity testToTake = new TestEntity();

        // Find the test the user selected and instantiate the test from the one in the allTests List
        for (TestEntity test : allTests) {
            if (Objects.equals(test.getId().toString(),  takeThisTest)) {
                testToTake = test;
            }
        }

        /** TODO: Return the user to the main menu if an invalid input was entered **/

        System.out.println("You have selected the test: \n" + testToTake.getName() + "\n\nLoading questions...");

        // Save the answers the user input to count the correct answers when grading.
        List<HashMap<Boolean, String>> selectedA = new ArrayList<>();

        /** Display the questions from the test, and handle each child question from QuestionParent **/
        for (QuestionParent question : testToTake.getQuestions()) {
            System.out.println("\n" + question.getQuestion());

            /** TODO: Create an escape option any time during the test **/

            /** Display the answers for MULTIPLECHOICE questions **/
            if (question.getClass() == MultipleChoice.class) {
                int id = 1;
                for (HashMap<Boolean, String> answers : ((MultipleChoice) question).getAnswers()) {
                    System.out.println(id + "." + answers.values());
                    id++;
                }

                System.out.println("\nWhich number has the correct answer?");
                String answer = mainMenuInput.nextLine();
                /** TODO: Make the sure the user selects a valid input **/

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

                /** TODO: Make the sure the user selects a valid input **/

                Boolean response = false;
                if (Objects.equals(answer, "1")) {
                    response = true;
                }

                /** Save the answers **/
                HashMap<Boolean, String> trueFalse = new HashMap<>();
                if (((TrueFalse) question).getAnswer() == response) {
                    trueFalse.put(response, "Correct");
                } else {
                    trueFalse.put(response, "Incorrect");
                }
                selectedA.add(trueFalse);

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

                /** TODO: Make the sure the user selects a valid input **/
                /** TODO: Make the sure the user does not enter duplicate selections **/

                while (true) {
                    String answer = mainMenuInput.nextLine();
                    if (Objects.equals(answer, "0")) {
                        break;
                    }
                    checkBoxResponses.add(answer);
                    System.out.println("Enter another answer?");
                }

                /** Find the users response and store the string to compare later **/
                int idCheck = 1;
                for (HashMap<Boolean, String> answers : ((CheckBox) question).getAnswers()) {
                    for (String inputs : checkBoxResponses) {
                        if (Integer.toString(idCheck).equals(inputs)) {
                            selectedA.add(answers);
                        }
                    }
                    idCheck++;
                }

            }
        }

        /** Grade Test with static method from TestEntity **/
        TestEntity.gradeTest(selectedA, gradeTestEntity);

    }

}
