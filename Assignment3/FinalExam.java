public class FinalExam extends Exam {
    /**
     * Constructor
     * @param total Total marks of this exam
     * @param score Marks of this exam user received
     */
    public FinalExam(int total, int score) {
        super(total, score);
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "FinalExam object with total=" + this.total + ", score=" + this.score;
    }

    public static void main(String[] args) {
        FinalExam finalExam = new FinalExam(100, 65);
        System.out.println(finalExam);
    }
}
