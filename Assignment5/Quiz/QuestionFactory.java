/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.util.ArrayList;

public class QuestionFactory {
    /**
     * The constructor for Quiz.QuestionFactory
     */
    public QuestionFactory() {
    }

    /**
     * Create and return question given text
     *
     * @param text is the question string ArrayList read from file
     * @return the question object
     */
    public Question createQuestion(ArrayList<String> text) {
//        System.out.println("Create Quiz.Question: "+text.getFirst());
        Quiz.typeQues type = Quiz.typeQues.valueOf(text.getFirst());
        Question question = null;
        ArrayList<String> arr = new ArrayList<>();
        arr.add(text.get(1));
        String answer = text.get(2);
        int i = 3;
        while (i < text.size()) {
            arr.add(text.get(i));
            i++;
        }
        switch (type) {
            case Quiz.typeQues.MULTIPLECHOICE:
                question = new MultipleChoice(arr, answer);
                break;
            case Quiz.typeQues.FILLIN:
                question = new FillIn(arr, answer);
        }
        return question;
    }

    /**
     * Regression test for this class
     *
     * @param args is not used in this test
     */
    public static void main(String[] args) {
        QuestionFactory f = new QuestionFactory();

        ArrayList<String> s = new ArrayList<>();
        s.add("MULTIPLECHOICE");
        s.add("Quiz.Question 1 Description");
        s.add("Quiz.Question 1 Answer");
        s.add("Option 1");
        s.add("Option 2");
        s.add("Option 3");
        Question q = f.createQuestion(s);
        System.out.println(q);

        ArrayList<String> s2 = new ArrayList<>();
        s2.add("FILLIN");
        s2.add("Quiz.Question 2 Description");
        s2.add("Quiz.Question 2 Answer");
        Question q2 = f.createQuestion(s2);
        System.out.println(q2);
    }
}
