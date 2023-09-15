package org.example;

import java.util.*;

public class TestEntity {

    private static int idCount = 1;
    private Long id = 0L;
    private String name;
    private List<QuestionParent> questions = new ArrayList<>();

    public TestEntity(String name, List<QuestionParent> questions) {
        this.id = (long) idCount++; // Casting example, convert our int into a long
        this.name = name;
        this.questions = questions;
    }

    public TestEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionParent> getQuestions() {
        return questions;
    }

    /** Grade the test the user took, requires a list of HashMaps that consist of the user input
     * Requires a TestEntity to get the count of total answers **/
    // TODO: Change TestEntity to an int, and pass in the number from Main.
    // We can dry our code by passing in the total from main and not the TestEntity itself.
    public static void gradeTest (List<HashMap<Boolean, String>> toGrade, TestEntity testEntity) {

        int testTotalScoreBase = 0;
        int userScore = 0;

        /** Count the total correct questions in the Test **/
        for (QuestionParent answer : testEntity.getQuestions()) {
            if (answer.getClass() == CheckBox.class) {
                for (HashMap<Boolean, String> answers : ((CheckBox) answer).getAnswers()) {
                    if(Objects.equals(QuestionParent.removeBrackets(answers.keySet().toString()), "true")) {
                        testTotalScoreBase++;
                    }
                }
            }
            if (answer.getClass() == MultipleChoice.class) {
                testTotalScoreBase++;
            }
            if (answer.getClass() == TrueFalse.class) {
                testTotalScoreBase++;
            }
        }

        /** Count all the answers the user got correct **/
        for (HashMap<Boolean, String> answers : toGrade) {
            /** TRUEFALSE have a value of Correct or Incorrect, based on that we can assign the point **/
            if (Objects.equals(QuestionParent.removeBrackets(answers.values().toString()), "Correct")) {
                userScore++;
            } else if (Objects.equals(QuestionParent.removeBrackets(answers.values().toString()), "Incorrect")) {
            } else {
                /** MultipleChoice and CheckBox have their answers as hashmaps, if one is true, it's correct and add the point, else it is incorrect and no point. **/
                if (Objects.equals(QuestionParent.removeBrackets(answers.keySet().toString()), "true")) {
                    System.out.println();
                    userScore++;
                } else if (Objects.equals(QuestionParent.removeBrackets(answers.keySet().toString()), "false")) {
                }
        }
        }

        double score = (double) userScore / testTotalScoreBase * 100;
        System.out.println("\nMaxScore: " + testTotalScoreBase + "\nUserScore: " + userScore + "\nPercent: " + score + "\n");




    }


    /** Generate our default questions **/
    public static TestEntity createDefaultTest() {

        List<QuestionParent> defaultTest = new ArrayList<>();

        List<HashMap<Boolean, String>> multipleChoice1answers = new ArrayList<>();
        HashMap<Boolean, String> answerMc1 = new HashMap<>();
        answerMc1.put(false, "The practice of storing an object of one type in a variable of another type");
        multipleChoice1answers.add(answerMc1);
        HashMap<Boolean, String> answerMc2 = new HashMap<>();
        answerMc2.put(false, "One object inheriting another");
        multipleChoice1answers.add(answerMc2);
        HashMap<Boolean, String> answerMc3 = new HashMap<>();
        answerMc3.put(false, "Shape shifting");
        multipleChoice1answers.add(answerMc3);
        HashMap<Boolean, String> answerMc4 = new HashMap<>();
        answerMc4.put(true, "An abstract class with many classes extending from it");
        multipleChoice1answers.add(answerMc4);
        MultipleChoice multipleChoice1 = new MultipleChoice("Polymorphism refers to:", multipleChoice1answers);


        List<HashMap<Boolean, String>> multipleChoice2answers = new ArrayList<>();
        HashMap<Boolean, String> answer2Mc1 = new HashMap<>();
        answer2Mc1.put(false, "When a class has no real data or behavior");
        multipleChoice2answers.add(answer2Mc1);
        HashMap<Boolean, String> answer2Mc2 = new HashMap<>();
        answer2Mc2.put(false, "When expressionism just won’t cut it");
        multipleChoice2answers.add(answer2Mc2);
        HashMap<Boolean, String> answer2Mc3 = new HashMap<>();
        answer2Mc3.put(false, "When that class needs to be instantiated in more than one package");
        multipleChoice2answers.add(answer2Mc3);
        HashMap<Boolean, String> answer2Mc4 = new HashMap<>();
        answer2Mc4.put(true, "When shared behavior is desired among a group of non-abstract classes");
        multipleChoice2answers.add(answer2Mc4);
        MultipleChoice multipleChoice2 = new MultipleChoice("When might a programmer want to make a class abstract?", multipleChoice2answers);


        List<HashMap<Boolean, String>> multipleChoice3answers = new ArrayList<>();
        HashMap<Boolean, String> answer3Mc1 = new HashMap<>();
        answer3Mc1.put(false, "Subclass");
        multipleChoice3answers.add(answer3Mc1);
        HashMap<Boolean, String> answer3Mc2 = new HashMap<>();
        answer3Mc2.put(true, "Extension Class");
        multipleChoice3answers.add(answer3Mc2);
        HashMap<Boolean, String> answer3Mc3 = new HashMap<>();
        answer3Mc3.put(false, "Child Class");
        multipleChoice3answers.add(answer3Mc3);
        HashMap<Boolean, String> answer3Mc4 = new HashMap<>();
        answer3Mc4.put(false, "Derived Class");
        multipleChoice3answers.add(answer3Mc4);
        MultipleChoice multipleChoice3 = new MultipleChoice("Which of the following is NOT a term for one class that extends another?", multipleChoice3answers);


        TrueFalse trueFalse4 = new TrueFalse("You can create an abstract method", true);
        TrueFalse trueFalse5 = new TrueFalse("Inheritance is NOT one of the four pillars of Object Oriented Programming", false);
        TrueFalse trueFalse6 = new TrueFalse("We use the extends keyword to pass down all properties of the parent class to the child class", true);
        TrueFalse trueFalse7 = new TrueFalse("A class derived from an abstract class must implement all of the abstract methods it inherits.", true);
        TrueFalse trueFalse8 = new TrueFalse("True/False: When making class diagrams, the main idea is to get the design rules just right so that you won’t need to update your classes in the future.", true);


        List<HashMap<Boolean, String>> checkBox9answers = new ArrayList<>();
        HashMap<Boolean, String> checkBox9Cb1 = new HashMap<>();
        checkBox9Cb1.put(true, "you");
        checkBox9answers.add(checkBox9Cb1);
        HashMap<Boolean, String> checkBox9Cb2 = new HashMap<>();
        checkBox9Cb2.put(true, "up");
        checkBox9answers.add(checkBox9Cb2);
        HashMap<Boolean, String> checkBox9Cb3 = new HashMap<>();
        checkBox9Cb3.put(true, "never");
        checkBox9answers.add(checkBox9Cb3);
        HashMap<Boolean, String> checkBox9Cb4 = new HashMap<>();
        checkBox9Cb4.put(true, "gonna");
        checkBox9answers.add(checkBox9Cb4);
        HashMap<Boolean, String> checkBox9Cb5 = new HashMap<>();
        checkBox9Cb5.put(true, "let");
        checkBox9answers.add(checkBox9Cb5);
        HashMap<Boolean, String> checkBox9Cb6 = new HashMap<>();
        checkBox9Cb6.put(true, "you");
        checkBox9answers.add(checkBox9Cb6);
        HashMap<Boolean, String> checkBox9Cb7 = new HashMap<>();
        checkBox9Cb7.put(true, "down");
        checkBox9answers.add(checkBox9Cb7);
        CheckBox checkBox9 = new CheckBox("Never gonna give", checkBox9answers);

        List<HashMap<Boolean, String>> checkBox10answers = new ArrayList<>();
        HashMap<Boolean, String> checkBox10Cb1 = new HashMap<>();
        checkBox10Cb1.put(true, "Polymorphism");
        checkBox10answers.add(checkBox10Cb1);
        HashMap<Boolean, String> checkBox10Cb2 = new HashMap<>();
        checkBox10Cb2.put(false, "Deconstruction");
        checkBox10answers.add(checkBox10Cb2);
        HashMap<Boolean, String> checkBox10Cb3 = new HashMap<>();
        checkBox10Cb3.put(true, "Inheritance");
        checkBox10answers.add(checkBox10Cb3);
        HashMap<Boolean, String> checkBox10Cb4 = new HashMap<>();
        checkBox10Cb4.put(false, "Instantiation");
        checkBox10answers.add(checkBox10Cb4);
        HashMap<Boolean, String> checkBox10Cb5 = new HashMap<>();
        checkBox10Cb5.put(true, "Abstraction");
        checkBox10answers.add(checkBox10Cb5);
        HashMap<Boolean, String> checkBox10Cb6 = new HashMap<>();
        checkBox10Cb6.put(true, "Encapsulation");
        checkBox10answers.add(checkBox10Cb6);
        HashMap<Boolean, String> checkBox10Cb7 = new HashMap<>();
        checkBox10Cb7.put(false, "Keys, Phone, Wallet, Watch");
        checkBox10answers.add(checkBox10Cb7);
        CheckBox checkBox10 = new CheckBox("What are the 4 pillars of Object Oriented Programming?", checkBox10answers);


        defaultTest.add(multipleChoice1);
        defaultTest.add(multipleChoice2);
        defaultTest.add(multipleChoice3);
        defaultTest.add(trueFalse4);
        defaultTest.add(trueFalse5);
        defaultTest.add(trueFalse6);
        defaultTest.add(trueFalse7);
        defaultTest.add(trueFalse8);
        defaultTest.add(checkBox10);
        defaultTest.add(checkBox9);


        return new TestEntity("LC 101, unit 2", defaultTest);
    }
}
