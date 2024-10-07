import javax.lang.model.type.NullType;

public class Course {
    /**
     * Name of the course
     */
    private String courseName;
    /**
     * Container for the Assignment objects
     */
    private Assignment[] assignments;
    /**
     * Current assignment numbers
     */
    private int assignmentIdx;
    /**
     * Container for the Quiz objects
     */
    private Quiz[] quizzes;
    /**
     * Current quiz numbers
     */
    private int quizIdx;
    /**
     * Midterm object
     */
    private Midterm midterm;
    /**
     * Lab Exam 1 object
     */
    private LabExam labExam1;
    /**
     * Lab Exam 2 object
     */
    private LabExam labExam2;
    /**
     * Final Exam object
     */
    private FinalExam finalExam;

    /**
     * Constructor
     * @param name name of the course
     * @param numAssignments numbers of total assignments
     * @param numQuizzes numbers of total quizzes
     */
    public Course(String name, int numAssignments, int numQuizzes) {
        this.courseName = name;
        this.assignments = new Assignment[numAssignments];
        this.quizzes = new Quiz[numQuizzes];
        this.assignmentIdx = 0;
        this.quizIdx = 0;
        this.midterm = new Midterm(1,0);
        this.labExam1 = new LabExam(1,0);
        this.labExam2 = new LabExam(1,0);
        this.finalExam = new FinalExam(1,0);
    }

    /**
     * Create an Assignment object and add it to the container
     * @param total Total marks of this assignment
     * @param score Marks of this assignment user received
     */
    public void addAssignment(int total, int score) {
//        System.out.println("Add assignment with total="+total+" score="+score);
        Assignment assignment = new Assignment(total, score);
        this.assignments[this.assignmentIdx] = assignment;
        this.assignmentIdx += 1;
    }

    /**
     * Create a Quiz object and add it to the container
     * @param total Total marks of this quiz
     * @param score Marks of this quiz user received
     */
    public void addQuiz(int total, int score) {
//        System.out.println("Add quiz with total="+total+" score="+score);
        Quiz quiz = new Quiz(total, score);
        this.quizzes[this.quizIdx] = quiz;
        this.quizIdx += 1;
    }

    /**
     * Create a Midterm object
     * @param total Total marks of this midterm
     * @param score Marks of this midterm user received
     */
    public void addMidterm(int total, int score) {
//        System.out.println("Add midterm with total="+total+" score="+score);
        this.midterm = new Midterm(total, score);
    }

    /**
     * Create a LabExam object
     * @param examNumber the LabExam index which should be 1 or 2
     * @param total Total marks of this lab exam
     * @param score Marks of this lab exam user received
     */
    public void addLabExam(int examNumber, int total, int score) {
//        System.out.println("Add lab exam "+examNumber+" with total="+total+" score="+score);
        if (examNumber == 1) {
            this.labExam1 = new LabExam(total, score);
        } else {
            this.labExam2 = new LabExam(total, score);
        }
    }

    /**
     * Create a FinalExam object
     * @param total Total marks of this final exam
     * @param score Marks of this final exam user received
     */
    public void addFinalExam(int total, int score) {
//        System.out.println("Add final exam with total="+total+" score="+score);
        this.finalExam = new FinalExam(total, score);
    }

    /**
     * Calculate and return the final grade of the user
     * @return final grade of the user
     */
    public double getFinalGrade() {
//        System.out.println("Get final grade "+0.0);
//        Score weighting
        double w_asn=15, w_quiz =5, w_mid=15, w_lab1=5, w_lab2=15, w_fnl=45;
//        Calculate assignments' percentage
        int asnNumerator = 0, asnDenominator = 0;
        for (int i=0; i<this.assignmentIdx; ++i) {
            asnNumerator += assignments[i].getScore();
            asnDenominator += assignments[i].getTotal();
        }
        asnDenominator = (asnDenominator == 0) ? 1 : asnDenominator;
        double asnPercentage = ((double) asnNumerator) / ((double) asnDenominator);
//        Calculate quizzes' percentage
        int quizNumerator = 0, quizDenominator = 0;
        for (int i=0; i<this.quizIdx; ++i) {
            quizNumerator += quizzes[i].getScore();
            quizDenominator += quizzes[i].getTotal();
        }
        quizDenominator = (quizDenominator == 0) ? 1 : quizDenominator;
        double quizPercentage = ((double) quizNumerator) / ((double) quizDenominator);
//        Return final score
        return asnPercentage * w_asn +
                quizPercentage * w_quiz +
                this.midterm.getPercentage() * w_mid +
                this.labExam1.getPercentage() * w_lab1 +
                this.labExam2.getPercentage() * w_lab2 +
                this.finalExam.getPercentage() * w_fnl;
    }

    /**
     * Get the course name
     * @return the course name `courseName`
     */
    public String getCourseName() {
//        System.out.println("Get course name "+this.courseName);
        return this.courseName;
    }

    /**
     * Get the String representation of this object
     * @return the String representation of this object
     */
    public String toString() {
        return "Course object with courseName="+this.courseName+":\n"+this.assignmentIdx+" assignments, "+this.quizIdx+" quizzes.";
    }

    public static void main(String[] args) {
        Course course = new Course("CMPT270", 100, 100);
        course.addAssignment(100, 50);
        course.addAssignment(100, 50);
        course.addQuiz(100, 50);
        course.addQuiz(100, 50);
        course.addMidterm(100, 50);
        course.addLabExam(1, 100, 50);
        course.addLabExam(2, 100, 50);
        course.addFinalExam(100, 50);
        String c = course.getCourseName();
        double d = course.getFinalGrade();
        System.out.println("courseName: " + c);
        System.out.println("finalGrade: " + d);
        System.out.println(course);
        Course course2 = new Course("CPMT270", 100, 100);
        String e = course2.getCourseName();
        double f = course2.getFinalGrade();
        System.out.println("courseName: " + e);
        System.out.println("finalGrade: " + f);
        System.out.println(course2);
    }
}
