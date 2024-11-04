/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.util.ArrayList;

public class MultipleChoice extends Question{
    /**
     * Constructor for Quiz.MultipleChoice Quiz.Question
     *
     * @param description is the question description
     * @param answer      is the answer to this question
     */
    public MultipleChoice(ArrayList<String> description, String answer) {
        super(description, answer);
        this.type = Quiz.typeQues.MULTIPLECHOICE;
    }

    /**
     * Get the description of this question
     *
     * @return the description to this question
     */
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        for (String s : this.description) {
            sb.append(s);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    /**
     * Regression test for this class
     *
     * @param args is not used in this test
     */
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Description");
        s.add("Option1");
        s.add("Option2");
        MultipleChoice multi = new MultipleChoice(s, "Answer");
        System.out.println(multi.getType());
        System.out.println(multi.getDescription());
        System.out.println(multi.getAnswer());
        System.out.println(multi.getNumOptions());
    }
}
