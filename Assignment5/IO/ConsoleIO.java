/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package IO;

import Quiz.Quiz;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleIO implements IO {

    /**
     * The private static instance to follow the Singleton pattern that allows single IO.IO.ConsoleIO instance
     */
    private static ConsoleIO instance;
    /**
     * The scanner object for receiving user input
     */
    private Scanner scanner;
    /**
     * A String record user's NSID
     */
    private String nsid;
    /**
     * A double record user's score
     */
    private double score;
    /**
     * The private constructor for IO.IO.ConsoleIO class
     */
    private ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Set the Console as IO.IO instance if not exist, return the IO.IO instance
     *
     * @return the IO.IO instance
     */
    public static ConsoleIO getInstance() {
        if (instance == null) {
            instance = new ConsoleIO();
        }
        return instance;
    }

    /**
     * A function to handle all the quiz process by IO.IO.ConsoleIO
     */
    @Override
    public void startQuiz(String fpath) {
//        System.out.println("Start Quiz.Quiz");
        // start quiz
        Quiz quiz = new Quiz();
        try {
            quiz.loadQuestions(fpath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+fpath);
            System.exit(1);
        }

        // greeting
        System.out.println("\nSystem: Welcome to Quiz.Quiz System!");
        System.out.println("System: You will have 10 questions in this quiz, and unlimited time to solve it.");
        System.out.print("System: Enter your NSID to start the quiz...\n\nNSID: ");
        this.nsid = this.scanner.nextLine();

        int idx = 1;
        while (quiz.haveNextQuestion()) {
            quiz.nextQuestion();
            System.out.println("\nQuiz.Question "+idx+":");
            System.out.print(quiz.getQuestionDescription()+"\n\nAnswer: ");
            String buffer = scanner.nextLine();
            if (buffer.equals(quiz.getQuestionAnswer())) {
                quiz.addScore();
            }
            idx += 1;
        }
        this.score = quiz.getFinalScore();
    }

    /**
     * Get user's NSID
     *
     * @return NSID of the user
     */
    @Override
    public String getNsid() {
        return this.nsid;
    }

    /**
     * Get user's quiz score
     *
     * @return quiz score
     */
    @Override
    public double getScore() {
        return this.score;
    }

    /**
     * Regression test for this class
     *
     * @param args is not used in this test
     */
    public static void main(String[] args) {
        String fpath = "./Assignment5/questions.txt";
        ConsoleIO instance = ConsoleIO.getInstance();
        ConsoleIO instance2 = ConsoleIO.getInstance();
        System.out.println(instance == instance2);
        instance.startQuiz(fpath);
        double score = instance.getScore();
        String nsid = instance.getNsid();
        System.out.println("\nNSID: "+nsid);
        System.out.println("Score: "+score);
    }
}
