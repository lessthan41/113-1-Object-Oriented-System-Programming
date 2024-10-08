import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class AchievementDemo {

    public static void main(String[] args)
    {
        // Create an object to read achievements from a text file
        AchievementFileReader reader = new AchievementFileReader();
        // Declare the achievement manager so it has scope to the entire main program
        AchievementManager manager = null;
        // Set up the scanner to read from console
        Scanner sc = new Scanner(System.in);

        // todo: there is a problem with this line that prevents the program from compiling. Fix it.
        try
        {
            manager = reader.readAchievements("Assignment4/achievements.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The achievements file could not be found.");
            exit(1);
        }

        boolean isQuit = false;

        while(!isQuit)
        {
            System.out.println("- - - - - -");
            System.out.println("Currently reading from " + reader.getCurrentFilePath());
            System.out.println("- - - - - -");
            System.out.println("Please make a selection:");
            System.out.println("\t 1. Save current achievement list");
            System.out.println("\t 2. Add an Achievement");
            System.out.println("\t 3. Print current achievement list");
            System.out.println("\t 0. Quit without saving");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 0:
                    isQuit = true;
                    break;
                case 1:
                    // todo: there is a problem with this line that prevents the program from compiling. Fix it.
                    try
                    {
                        reader.writeAchievements(manager);
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("The achievements file could not be found.");
                        exit(1);
                    }
                    break;
                case 2:
                    System.out.println("Enter achievement name:");
                    // This line is needed to clear out any possible junk still in the Scanner Object
                    // It will not affect the program, but without it, reading achievementName will sometimes
                    // be skipped
                    sc.nextLine();
                    String achievementName = sc.nextLine();
                    System.out.println("Enter achievement description:");
                    String achievementDescription = sc.nextLine();
                    // todo: create a new achievement object and add it to the achievement manager
                    Achievement achievement = new Achievement(achievementName, achievementDescription);
                    manager.addAchievement(achievement);
                    break;
                case 3:
                    System.out.println(manager);
                    break;
            }
        }
    }
}
