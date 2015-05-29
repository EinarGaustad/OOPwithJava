package inheritance;

/**
 * This file is part of learnJava
 * <p/>
 * Created by GuoJunjun <junjunguo.com> on May 22, 2015.
 */
public class Question {

    private String text;
    protected String answer;

    public Question() {
        text = "";
        answer = "";
    }

    /**
     * Sets the question text.
     *
     * @param questionText the text of this question
     */
    public void setText(String questionText) {
        text = questionText;
    }

    /**
     * Sets the answer for this question.
     *
     * @param correctResponse the answer
     */
    public void setAnswer(String correctResponse) {
        answer = correctResponse;
    }

    public boolean checkAnswer(String response) {
        return response.equals(answer);
    }

    public void display() {
        System.out.println(text);
    }


    /**can only access by getText(), (text is private, only visible bor this class)
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**can access to answer it is protected
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }
}
