/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package IO;

import Quiz.Quiz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GUI extends JFrame implements IO {
    /**
     * The private static instance to follow the Singleton pattern that allows single IO.IO.ConsoleIO instance
     */
    private static GUI instance;
    /**
     * The main panel for IO.GUI
     */
    private JPanel panel = new JPanel();
    /**
     * A collections of JLabel for instruction to be printed
     */
    ArrayList<JLabel> descriptions = new ArrayList<>();
    /**
     * JTextField for receiving user input value
     */
    JTextField inputField = new JTextField(10);
    /**
     * A collection of JButtons for Quiz.MultipleChoice questions
     */
    ArrayList<JButton> multipleChoiceButtons = new ArrayList<>();
    /**
     * A JButton for fill-in questions
     */
    JButton fillInButton = new JButton("Submit");
    /**
     * A JButton for setting nsid
     */
    JButton nsidButton = new JButton("Start");
    /**
     * A lock to synchronize the main program with the IO.GUI
     */
    CountDownLatch lock = new CountDownLatch(1);
    /**
     * The quiz instance to perform the quiz
     */
    private Quiz quiz;
    /**
     * A String buffer to record user's answer
     */
    private String buffer;
    /**
     * A String record user's NSID
     */
    private String nsid;
    /**
     * A double record user's score
     */
    private double score;

    /**
     * The constructor for IO.GUI class
     */
    private GUI(){
        this.setTitle("Quiz.Quiz System");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel.setSize(500, 500);
        GridLayout layout = new GridLayout(12, 1);
        layout.setHgap(10);
        layout.setVgap(10);
        this.panel.setLayout(layout);

        this.panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setContentPane(this.panel);
        this.setResizable(false);

        this.nsidButton.addActionListener(new NsidListener());
        this.fillInButton.addActionListener(new FillInListener());
    }

    /**
     * Set the IO.GUI as IO.IO instance if not exist, return the IO.IO instance
     *
     * @return the IO.IO instance
     */
    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    /**
     * A starter function to begin the quiz process by IO.GUI
     */
    @Override
    public void startQuiz(String fpath) {

        // greeting
        this.descriptions.add(new JLabel("Welcome to Quiz.Quiz System!"));
        this.descriptions.getFirst().setFont(new Font("", Font.BOLD, 20));
        this.descriptions.add(new JLabel("You will have 10 questions in this quiz, and unlimited time to solve it."));
        this.descriptions.add(new JLabel("Enter your NSID to start the quiz: "));

        this.panel.add(this.descriptions.getFirst());
        this.panel.add(this.descriptions.get(1));
        this.panel.add(this.descriptions.get(2));
        this.panel.add(this.inputField);
        this.panel.add(this.nsidButton);

        // read quiz file
        this.quiz = new Quiz();
        try {
            this.quiz.loadQuestions(fpath);
            // start IO.GUI
            this.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+fpath);
            System.exit(1);
        }

        // lock and wait for quiz finish
        try {
            this.lock.await();
        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception Occurred");
            System.exit(1);
        }
    }

    /**
     * Change IO.GUI for the next question, if there is not any question, call `endQuiz()`
     */
    private void nextQuestion() {
        if (this.quiz.haveNextQuestion()) {
            // next question
            this.quiz.nextQuestion();
            int q = this.quiz.getCurrentQuestion() + 1;
            Quiz.typeQues type = this.quiz.getQuestionType();
            this.descriptions.getFirst().setText("Quiz.Question "+q+":");

            // add labels
            String[] arr = this.quiz.getQuestionDescription().split("\n");
            while (this.descriptions.size() < arr.length+1) {
                JLabel l = new JLabel();
                this.descriptions.add(l);
            }
            int idx = 1;
            for (String s : arr) {
                this.descriptions.get(idx).setText(s);
                idx += 1;
            }

            // clear panel
            this.panel.removeAll();
            for (int i = 0; i < arr.length+1; i++) {
                this.panel.add(this.descriptions.get(i));
            }

            switch (type) {
                case MULTIPLECHOICE:
                    int numOptions = this.quiz.getQuestionNumOptions();
                    while (this.multipleChoiceButtons.size() < numOptions) {
                        JButton button = new JButton();
                        button.addActionListener(new MultipleChoiceListener());
                        this.multipleChoiceButtons.add(button);
                    }
                    for (int i=0; i<numOptions; i++) {
                        int ascii = 'A';
                        char text = (char) (ascii+i);
                        this.multipleChoiceButtons.get(i).setText(Character.toString(text));
                        this.panel.add(this.multipleChoiceButtons.get(i));
                    }
                    break;
                case FILLIN:
                    this.panel.add(this.inputField);
                    this.panel.add(this.fillInButton);
                    break;
                default:
                    break;
            }
            // refresh panel
            this.panel.revalidate();
            this.panel.repaint();
        } else {
            // end quiz
            this.score = this.quiz.getFinalScore();
            this.endQuiz();
        }
    }

    /**
     * A ending function for the quiz, showing NSID and final score on the IO.GUI, and release `lock`
     */
    private void endQuiz() {
        // set up quiz ending
        this.descriptions.getFirst().setText("Quiz.Quiz Finished");
        this.descriptions.get(1).setText("NSID: "+this.nsid);
        this.descriptions.get(2).setText("Score: "+this.quiz.getFinalScore());

        // clear panel
        this.panel.removeAll();
        this.panel.add(this.descriptions.getFirst());
        this.panel.add(this.descriptions.get(1));
        this.panel.add(this.descriptions.get(2));

        // lock release to let main program continue
        this.lock.countDown();

        // refresh panel
        this.panel.revalidate();
        this.panel.repaint();
    }

    /**
     * Button click listener to set NSID and start the quiz
     */
    class NsidListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nsid = inputField.getText();
            inputField.setText("");
            nextQuestion();
        }
    }

    /**
     * Button click listener for multiple-choice question
     */
    class MultipleChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buffer = e.getActionCommand();
            if (buffer.equals(quiz.getQuestionAnswer())) {
                quiz.addScore();
            }
            nextQuestion();
        }
    }

    /**
     * Button click listener for fill-in question
     */
    class FillInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buffer = inputField.getText();
            inputField.setText("");
            if (buffer.equals(quiz.getQuestionAnswer())) {
                quiz.addScore();
            }
            nextQuestion();
        }
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
        GUI instance = GUI.getInstance();
        GUI instance2 = GUI.getInstance();
        System.out.println(instance == instance2);
        instance.startQuiz(fpath);
        String nsid = instance.getNsid();
        double score = instance.getScore();
        System.out.println("\nNSID: "+nsid);
        System.out.println("Score: "+score);
    }
}
