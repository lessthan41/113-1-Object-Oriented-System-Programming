/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

import IO.GUI;
import IO.ConsoleIO;

public class Main {
    public static void main(String[] args) {

        // set file path to question.txt
        String fpath = "./Assignment5/questions.txt";

        // specify IO.IO type
//        IO.ConsoleIO instance = IO.ConsoleIO.getInstance();
        IO.GUI instance = IO.GUI.getInstance();

        // start quiz
        instance.startQuiz(fpath);

        // print nsid and score
        System.out.println("\nNSID: " + instance.getNsid());
        System.out.println("Score: " + instance.getScore());
    }
}