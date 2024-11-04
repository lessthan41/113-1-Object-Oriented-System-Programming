/**
 * Name: Evan Ho (Cheng-Yu Ho)
 * NSID: oim452
 * Student Number: 11412025
 */

package Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    /**
     * The current file path where achievement are read from/written to
     */
    private String filePath;

    /**
     * A File object at the location indicated by filePath
     */
    private File myObj;

    /**
     * Constructor, initialize reader with empty file path
     */
    public FileIO() {
        this.filePath = "";
    }

    /**
     * reads lines of text from a text file at a specified file location
     * @param filepath filepath to text file where achievements are saved
     * @return a List of Strings, representing each line in the text file
     * @throws FileNotFoundException if the file location does not exist
     */
    public ArrayList<String> readFile(String filepath) throws FileNotFoundException
    {
        filePath = filepath;
        ArrayList<String> lines = new ArrayList<String>();
        Scanner sc = null;
        try
        {
            myObj = new File(this.filePath);
            sc = new Scanner(myObj);
            while(sc.hasNextLine())
            {
                lines.add(sc.nextLine());
            }
        }
        finally{
            if(sc != null)
                sc.close();
        }
        return lines;
    }

    /**
     * Writes a series of lines to the same text file as read from earlier
     * @param lines a List of Strings, each of which should be written into the file
     * @throws FileNotFoundException if the file does not exist at the saved location
     */
    public void writeFile(ArrayList<String> lines) throws FileNotFoundException
    {
        try(PrintWriter pw = new PrintWriter(myObj))
        {
            for(String line : lines)
            {
                pw.println(line);
            }
        }
    }

    /**
     * Returns the path where text is to be read from/written to
     * @return the currently saved file path
     */
    public String getCurrentFilePath()
    {
        return this.filePath;
    }
}
