import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Course name
        System.out.print("Enter the name of the course: ");
        String courseName = sc.nextLine();

//        Score weighting
        double w_asn=15, w_quiz =5, w_mid=15, w_lab1=5, w_lab2=15, w_fnl=45;

//        User input record
        int selectedOption=-1, asnNum=1, quizNum=1;
        double asnFull=0, asnEarn=0, quizFull=0, quizEarn=0, midFull=0, midEarn=0,
                lab1Full=0, lab1Earn=0, lab2Full=0, lab2Earn=0, fnlFull=0, fnlEarn=0;

//        Looping Menu
        String menu = "\n1. Add mark for assignment.\n2. Add mark for quiz.\n3. Set mark for midterm.\n4. Set mark for lab exam 1.\n5. Set mark for lab exam 2.\n6. Set mark for final exam.\n7. Quit.\n\nSelect the option using keyboard: ";

//        Start looping menu
        do {
            System.out.print(menu);
            selectedOption = sc.nextInt();
            switch(selectedOption) {
                case 1:
                    System.out.print("Enter the assignment " + asnNum + "'s FULL mark: ");
                    asnFull += sc.nextDouble();
                    System.out.print("Enter the assignment " + asnNum + "'s EARNED mark: ");
                    asnEarn += sc.nextDouble();
                    asnNum += 1;
                    break;
                case 2:
                    System.out.print("Enter the quiz " + quizNum + "'s FULL mark: ");
                    quizFull = sc.nextDouble();
                    System.out.print("Enter the quiz " + quizNum + "'s EARNED mark: ");
                    quizEarn += sc.nextDouble();
                    quizNum += 1;
                    break;
                case 3:
                    System.out.print("Enter the midterm's FULL mark: ");
                    midFull = sc.nextDouble();
                    System.out.print("Enter the midterm's EARNED mark: ");
                    midEarn = sc.nextDouble();
                    break;
                case 4:
                    System.out.print("Enter the lab exam 1's FULL mark: ");
                    lab1Full = sc.nextDouble();
                    System.out.print("Enter the lab exam 1's EARNED mark: ");
                    lab1Earn = sc.nextDouble();
                    break;
                case 5:
                    System.out.print("Enter the lab exam 2's FULL mark: ");
                    lab2Full = sc.nextDouble();
                    System.out.print("Enter the lab exam 2's EARNED mark: ");
                    lab2Earn = sc.nextDouble();
                case 6:
                    System.out.print("Enter the final exam's FULL mark: ");
                    fnlFull = sc.nextDouble();
                    System.out.print("Enter the final exam's EARNED mark: ");
                    fnlEarn = sc.nextDouble();
                    break;
                case 7:
//                    Divide-by-zero handler
                    asnFull = (asnFull==0) ? 1 : asnFull;
                    quizFull = (quizFull==0) ? 1 : quizFull;
                    midFull = (midFull==0) ? 1 : midFull;
                    lab1Full = (lab1Full==0) ? 1 : lab1Full;
                    lab2Full = (lab2Full==0) ? 1 : lab2Full;
                    fnlFull = (fnlFull==0) ? 1 : fnlFull;
//                    Calculate final score
                    double sum = (asnEarn/asnFull) * w_asn +
                            (quizEarn/quizFull) * w_quiz +
                            (midEarn/midFull) * w_mid +
                            (lab1Earn/lab1Full) * w_lab1 +
                            (lab2Earn/lab2Full) * w_lab2 +
                            (fnlEarn/fnlFull) * w_fnl;
//                    Print final score
                    System.out.println("Name of the course: " + courseName);
                    System.out.println("Calculated Final Score: " + sum);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (selectedOption != 7);
    }
}
