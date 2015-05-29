package inheritance;

import java.util.ArrayList;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 22, 2015.
 */
public class ChoiceQuestion extends Question {

    private ArrayList<String> choices;

    public ChoiceQuestion() {
        choices = new ArrayList<String>();
    }

    public void addChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            // Convert choices.size() to string
            String choiceString = "" + choices.size();
            setAnswer(choiceString);
        }
    }

    public void display() {
        // Display the question text
        super.display();
        // Display the answer choices
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }

        System.out.println("getAnswer(public) + getText(public) + answer(protected); can not + text(private):" +
                           getAnswer() + "\n" + getText() + "\n" + answer);
    }
}
