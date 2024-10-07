import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of this course: ");
        String courseName = scanner.nextLine();

        Course course = new Course(courseName, 100, 100);

        // boolean flag to keep the menu looping until user selects the quit option
        boolean isQuit = false;

        // menu will loop until the boolean flag is flipped
        while(!isQuit)
        {
            // present user with the menu of options
            System.out.println("Choose an option: ");
            System.out.println("1. Add an assignment");
            System.out.println("2. Add midterm");
            System.out.println("3. Add a quiz");
            System.out.println("4. Add lab exam 1");
            System.out.println("5. Add lab exam 2");
            System.out.println("6. Add final exam");
            System.out.println("7. Calculate grade and quit");

            // read user's choice
            int choice = scanner.nextInt();

            int total = 0;
            int score = 0;

            // handle the various commands, based on the user's entered choice
            switch(choice)
            {
                case 1:
                    // read in the total weight and score for a single assignment
                    // add both to the current running totals
                    System.out.println("How many marks was the assignment worth?");
                    total = scanner.nextInt();
                    System.out.println("How many marks did you receive on the assignment?");
                    score = scanner.nextInt();
                    course.addAssignment(total, score);
                    break;
                case 2:
                    // read in the total weight and score for the midterm exam
                    System.out.println("How many marks was the midterm worth?");
                    total = scanner.nextInt();
                    System.out.println("How many marks did you receive on the midterm?");
                    score = scanner.nextInt();
                    course.addMidterm(total, score);
                    break;
                case 3:
                    // read in the total weight and score for a single quiz
                    // add both to the current running totals
                    System.out.println("How many marks was the quiz worth?");
                    total = scanner.nextInt();
                    System.out.println("How marks did you receive on the quiz?");
                    score = scanner.nextInt();
                    course.addQuiz(total, score);
                    break;
                case 4:
                    // read in the total weight and score for lab exam 1
                    System.out.println("How many marks was the lab exam worth?");
                    total = scanner.nextInt();
                    System.out.println("How many marks did you receive on the lab exam?");
                    score = scanner.nextInt();
                    course.addLabExam(1, total, score);
                    break;
                case 5:
                    // read in the total weight and score for lab exam 2
                    System.out.println("How many marks was the lab exam worth?");
                    total = scanner.nextInt();
                    System.out.println("How many marks did you receive on the lab exam?");
                    score = scanner.nextInt();
                    course.addLabExam(2, total, score);
                        break;

                case 6:
                    // read in the total weight and score for the final exam
                    System.out.println("How many marks was the final exam worth?");
                    total = scanner.nextInt();
                    System.out.println("How many marks did you receive on the final exam?");
                    score = scanner.nextInt();
                    course.addFinalExam(total, score);
                    break;
                case 7:
                    // flip the boolean flag so the menu stops looping and application ends
                    isQuit = true;
                    System.out.println("Your grade in " + course.getCourseName() + ": " + course.getFinalGrade());
                    break;
                default:
                    // handling the case where the user enters an invalid option
                    System.out.println("Please choose a valid option.");
                    break;
            }
        }
    }
}
