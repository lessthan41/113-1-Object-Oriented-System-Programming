public class LabExam extends Exam {
    /**
     * Constructor
     * @param total Total marks of this exam
     * @param score Marks of this exam user received
     */
    public LabExam(int total, int score) {
        super(total, score);
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "LabExam object with total=" + this.total + ", score=" + this.score;
    }

    public static void main(String[] args) {
        LabExam labExam = new LabExam(100, 65);
        System.out.println(labExam);
    }
}
