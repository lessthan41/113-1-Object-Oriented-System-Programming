/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.util.ArrayList;

public class FillIn extends Question{

    /**
     * Constructor for the Quiz.FillIn Quiz.Question
     *
     * @param description is the question description
     * @param answer      is the answer to this question
     */
    public FillIn(ArrayList<String> description, String answer) {
        super(description, answer);
        this.type = Quiz.typeQues.FILLIN;
    }

    /**
     * Regression test for this class
     *
     * @param args is not used in this test
     */
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Description");
        FillIn fillin = new FillIn(s,"Answer");
        System.out.println(fillin.getType());
        System.out.println(fillin.getDescription());
        System.out.println(fillin.getAnswer());
        System.out.println(fillin.getNumOptions());
    }
}
