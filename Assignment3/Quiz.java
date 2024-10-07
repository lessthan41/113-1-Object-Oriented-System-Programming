public class Quiz extends Assessment{
    /**
     * Constructor
     * @param total Total marks of this assessment
     * @param score Marks of this assessment user received
     */
    public Quiz(int total, int score) {
        super(total, score);
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "Quiz object with total=" + this.total + ", score=" + this.score;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz(100, 50);
        System.out.println(quiz);
    }
}
