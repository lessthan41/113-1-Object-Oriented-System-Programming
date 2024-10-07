public class Assignment extends Assessment {
    /**
     * Constructor
     * @param total Total marks of this assessment
     * @param score Marks of this assessment user received
     */
    public Assignment(int total, int score) {
        super(total, score);
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "Assignment object with total=" + this.total + ", score=" + this.score;
    }

    public static void main(String[] args) {
        Assignment assignment = new Assignment(100, 25);
        System.out.println(assignment);
    }
}
