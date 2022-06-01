package com.example.quizzes;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionList> mathQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("If y = (sin(x))^3, then dy/dx = ?", "(cos(x))^3", "3(sin(x))^2", "-3(sin(x))^2 * cos(x)", "3(sin(x))^2 * cos(x)", "3(sin(x))^2 * cos(x)", "");
        final QuestionList question2 = new QuestionList("The position of a particle is given by the parametric equations x(t) = t^3 - 3t^2 and y(t) = 12t - 3t^2. At which of the following points (x,y) is the particle at rest?", "(-4,12)", "(-3,6)", "(-2,9)", "(0,0)", "(-4,12)", "");
        final QuestionList question3 = new QuestionList("Which integrand gives the length of the curve y = ln(x) from x = 1 to x = 2?", "sqrt(1 + (1/x^2))", "1 + (1/x^2)", "sqrt(1 + (ln(x))^2)", "1 + (ln(x))^2", "sqrt(1 + (1/x^2))", "");
        final QuestionList question4 = new QuestionList("If arcsin(x) = ln(y), then dy/dx = ?", "(xy) / (sqrt(1-x^2))", "y / (sqrt(1-x^2))", "y / (1+x^2)", "e^arcsin(x)", "y / (sqrt(1-x^2))", "");
        final QuestionList question5 = new QuestionList("If f is the function defined by f(x) = sqrt(|x-2|) for all x, which of the following statements must be true?", "f is differentiable at x = 2", "f is not continuous at x = 2", "f is continuous but not differentiable at x = 2", "x = 2 is a vertical asymptote of the graph of f", "f is continuous but not differentiable at x = 2", "");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    private static List<QuestionList> englishQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("In programming, what is an iteration?", "A decision point in a program", "Testing a program to make sure it works", "The repetition of steps in a program", "The order that instructions are carried out in a program", "The repetition of steps in a program", "");
        final QuestionList question2 = new QuestionList("Which of the following is a correct header for a method of the Example class that would return the value of the private instance variable x so that it can be used in a class other than Example?", "private int getX()", "public int getX()", "private void getX()", "public void getX(int x)", "public int getX()", "");
        final QuestionList question3 = new QuestionList("Which two statements are used to implement iteration?", "WHILE and IF", "FOR and WHIlE", "IF and ELSE", "ELSE and WHITE", "FOR and WHIlE", "");
        final QuestionList question4 = new QuestionList("Which of the following statements assigns a random integer between 25 and 60, inclusive, to rn?", "int rn = (int) (Math.random() * 25) + 60;", "int rn = (int) (Math.random() * 26) + 60;", "int rn = (int) (Math.random() * 25) + 36;", "int rn = (int) (Math.random() * 36) + 25;", "int rn = (int) (Math.random() * 36) + 25;", "");
        final QuestionList question5 = new QuestionList("What is a data structure used to implement list object, where elements in list are of same type?", "object", "static", "method", "array", "array", "");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    private static List<QuestionList> scienceQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("An object moving on a horizontal, frictionless surface makes a glancing collision with another object initially at rest on the surface. For this case which of the following is true about momentum and kinetic energy?", "Momentum is always conserved and KE may be conserved", "Both are always conserved", "Kinetic energy is always conserved and momentum may be conserved", "Neither is conserved", "Momentum is always conserved and KE may be conserved", "");
        final QuestionList question2 = new QuestionList("An electrical motor provides 0.50 W of mechanical power. How much time will it take the motor to life a 0.1 kg mass at constant speed from the floor to a shelf 2.0 m above the floor?", "0.25s", "0.40s", "1s", "4s", "4s", "");
        final QuestionList question3 = new QuestionList("If velocity of a particle is given by v(t) = 3t^2 - 2t + 4, what is the acceleration of the particle at t = 2s?", "10 m/s^2", "12 m/s^2", "4 m/s^2", "6 m/s^2", "10 m/s^2", "");
        final QuestionList question4 = new QuestionList("A proton moving along the positive x-axis enters an electric field that is directed along the positive y-axis. What is the direction of the electric force acting on the proton after it enters the electric field?", "Along the negative y-axis", "Along the positive y-axis", "Along the positive z-axis", "Along the negative z-axis", "Along the positive y-axis", "");
        final QuestionList question5 = new QuestionList("All the following statements about an isolated, solid charged conductor are correct EXCEPT:", "The electric field E just outside the conductor is directed parallel to the surface", "All parts of the conductor are the same potential", "All excess charge resides on the outer surface", "The electric field intensity inside the conductor is zero", "The electric field E just outside the conductor is directed parallel to the surface", "");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);

        return questionLists;
    }

    private static List<QuestionList> historyQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("When did the Revolutionary War end?", "1781", "1782", "1783", "1784", "1783", "");
        final QuestionList question2 = new QuestionList("Which of these was not an Axis Power?", "Italy", "France", "Germany", "Japan", "France", "");
        final QuestionList question3 = new QuestionList("Who was not a prominent civil rights activist?", "MLK Jr.", "W.E.B. Du Bois", "Virginia Woolf", "Rosa Parks", "Virginia Woolf", "");
        final QuestionList question4 = new QuestionList("", "", "", "", "", "", "");
        final QuestionList question5 = new QuestionList("", "", "", "", "", "", "");

        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);

        return questionLists;
    }

    public static List<QuestionList> getQuestions(String selectedTopicName) {
        switch(selectedTopicName) {
            case "math":
                return mathQuestions();
            case "english":
                return englishQuestions();
            case "science":
                return scienceQuestions();
            default:
                return historyQuestions();
        }
    }

}
