/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.util.ArrayList;

public abstract class Question {
    /**
     * The question type should be one of the value in the typeQues enum of Quiz.Quiz class
     */
    protected Quiz.typeQues type;
    /**
     * A string records the question description and options if exist
     * index 0: Quiz.Question description
     * index 1..n: Multiple choice options
     */
    protected ArrayList<String> description;
    /**
     * The answer to the question
     */
    protected String answer;

    /**
     * Constructor for Quiz.Question type
     *
     * @param description is the question description
     * @param answer is the answer to this question
     */
    public Question(ArrayList<String> description, String answer) {
        this.description = new ArrayList<>(description);
        this.answer = answer;
    }

    /**
     * Get the question type
     *
     * @return the question type of this question
     */
    public Quiz.typeQues getType() {
        return this.type;
    }

    /**
     * Get the description of this question
     *
     * @return the description to this question
     */
    public String getDescription() {
        return this.description.getFirst();
    }

    /**
     * Get the answer of this question
     *
     * @return the answer to this question
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * Get the number of options for this multiple choice question
     *
     * @return the number of options for this multiple choice question
     */
    public int getNumOptions() {
        return this.description.size() - 1;
    }

    /**
     * String representation of the class
     * @return the string representation
     */
    @Override
    public String toString() {
        return "Quiz.Question Type: " + this.type + "\nDescription: " + this.description + "\nAnswer: " + this.answer;
    }
}
