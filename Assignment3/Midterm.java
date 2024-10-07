public class Midterm extends Exam {
    /**
     * Constructor
     * @param total Total marks of this exam
     * @param score Marks of this exam user received
     */
    public Midterm(int total, int score) {
        super(total, score);
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "Midterm object with total=" + this.total + ", score=" + this.score;
    }

    public static void main(String[] args) {
        Midterm midterm = new Midterm(100, 35);
        System.out.println(midterm);
    }
}
