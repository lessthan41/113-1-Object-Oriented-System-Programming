/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Quiz {
    /**
     * An extendable enum contains possible quiz types
     */
    public static enum typeQues {
        MULTIPLECHOICE,
        FILLIN,
    };
    /**
     * An integer shows the index of current question
     */
    private int currQues;
    /**
     * A collection of questions in this quiz
     */
    private ArrayList<Question> questions;
    /**
     * An integer keep track of quiz score
     */
    private int score;

    /**
     * The constructor of the quiz
     */
    public Quiz() {
        this.questions = new ArrayList<>();
        this.currQues = -1;
        this.score = 0;
    }

    /**
     * Load questions in the file with path `fpath` and add to `questions` Arraylist
     *
     * @param fpath is the path to the question file
     */
    public void loadQuestions(String fpath) throws FileNotFoundException {

        // load file `fpath`
        QuestionFactory factory = new QuestionFactory();
        FileIO fileIO = new FileIO();
        ArrayList<String> files = null;
        files = fileIO.readFile(fpath);

        assert files != null;

        // create question with factory
        ArrayList<String> lines = new ArrayList<>();
        for (String line : files) {
            try {
                typeQues t = typeQues.valueOf(line);
                if (!lines.isEmpty()) {
                    Question q = factory.createQuestion(lines);
                    this.questions.add(q);
                    lines.clear();
                }
                lines.add(line);
            } catch (IllegalArgumentException e) {
                lines.add(line);
            }
        }

        // last question
        if (!lines.isEmpty()) {
            Question q = factory.createQuestion(lines);
            this.questions.add(q);
        }

//        System.out.println("Total Questions: " + this.questions.size());
    }

    /**
     * Get the current question description
     *
     * @return the current question description
     */
    public String getQuestionDescription() {
//        System.out.println("get question description");
        return (this.questions.get(this.currQues).getDescription());
    }

    /**
     * Get the current question type
     *
     * @return the current question type
     */
    public typeQues getQuestionType() {
//        System.out.println("get question type");
        return (this.questions.get(this.currQues).getType());
    }

    /**
     * Get the current question answer
     *
     * @return the current question answer
     */
    public String getQuestionAnswer() {
//        System.out.println("get question answer");
        return (this.questions.get(this.currQues).getAnswer());
    }

    /**
     * Get the option number of current question
     *
     * @return the option number of current question
     */
    public int getQuestionNumOptions() {
//        System.out.println("get question numOptions");
        return (this.questions.get(this.currQues).getNumOptions());
    }

    /**
     * Get the current question index
     * @return the current question index
     */
    public int getCurrentQuestion() {
        return this.currQues;
    }

    /**
     * Calculate and return the final score
     *
     * @return the final score of user
     */
    public double getFinalScore() {
//        System.out.println("calculate final score");
        return ((double) this.score) / ((double) this.questions.size()) * 100.0d;
    }

    /**
     * move to the next question by adding current question index
     *
     * @return a boolean value indicate whether there is a next question
     */
    public void nextQuestion() {
//        System.out.println("move to next question");
        this.currQues += 1;
    }

    /**
     * Get if there is any question left to be accessed by `nextQuestion()`
     * @return if there is any question left in this quiz
     */
    public boolean haveNextQuestion() {
        return (this.currQues+1 < this.questions.size());
    }

    /**
     * Add score for this quiz
     */
    public void addScore() {
        this.score += 1;
    }

    /**
     * Regression test of the class
     *
     * @param args is not used in this test
     */
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        try {
            quiz.loadQuestions("./Assignment5/questions.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        while (quiz.haveNextQuestion()) {
            quiz.nextQuestion();
            System.out.println(quiz.getQuestionDescription());
            System.out.println(quiz.getQuestionType());
            System.out.println(quiz.getQuestionAnswer());
            System.out.println(quiz.getQuestionNumOptions());
            quiz.addScore();
        }
        System.out.println(quiz.getFinalScore());
    }
}
