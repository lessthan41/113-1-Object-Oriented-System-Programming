public class Assessment {
    /**
     * Marks of this assessment worth
     */
    protected int total;
    /**
     * Marks of this assessment user received
     */
    protected int score;

    /**
     * Constructor
     * @param total Total marks of this assessment
     * @param score Marks of this assessment user received
     */
    public Assessment(int total, int score) {
        this.total = total;
        this.score = score;
    }

    /**
     * Get the marks of this assessment user received
     * @return marks of this assessment user received `score`
     */
    public int getScore() {
//        System.out.println("Get score: "+this.score);
        return this.score;
    }

    /**
     * Get the total marks of this assessment
     * @return total marks of this assessment `total`
     */
    public int getTotal() {
//        System.out.println("Get total: "+this.total);
        return this.total;
    }

    public static void main(String[] args) {
        Assessment assessment = new Assessment(100, 50);
        int i = assessment.getScore();
        int j = assessment.getTotal();
        System.out.println("score: " + i + " total " + j);
    }
}
