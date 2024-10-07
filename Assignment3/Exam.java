public class Exam {
    /**
     * Marks of this exam worth
     */
    protected int total;
    /**
     * Marks of this exam user received
     */
    protected int score;

    /**
     * Constructor
     * @param total Total marks of this exam
     * @param score Marks of this exam user received
     */
    public Exam(int total, int score) {
        this.total = total;
        this.score = score;
    }

    /**
     * Calculate and return the exam's percentage of the user
     * @return the exam's percentage of the user
     */
    public double getPercentage() {
//        System.out.println("Get exam percentage");

        return ((double) this.score) /  ((double) this.total);
    }

    public static void main(String[] args) {
        Exam exam = new Exam(100, 25);
        double d = exam.getPercentage();
        System.out.println(d);
    }
}
