import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;

public class CSC499Part1 {

    //Gets the list of names from a given file. Takes number of lines and file name
    static String[] getList(int fileLines, String fileName) {
        String[] nameList = new String[fileLines];

        int i = 0;
        String line = null;
        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                nameList[i] = line.trim();//Trims off any whitespace found in file
                i++;

            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {//Throws error when file isn't found
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {//Throws error when file can't be read
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
        return nameList;//Returns the list of names from the file
    }

    //Gets the number of lines from the given file. Takes filename
    static int getFileSize(String fileName) {
        int numOfLines = 0;
        try {

            File file = new File(fileName);
            if (file.exists()) {

                FileReader fr = new FileReader(file);
                LineNumberReader lineReader = new LineNumberReader(fr);

                while (lineReader.readLine() != null) {//Stops when there are no lines left in file
                    numOfLines++;
                }

                lineReader.close();
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
        return numOfLines;
    }

    static void writeToFile(String[] names) {
        try {
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            writer.print(names[0]);
            for (int i = 1; i < names.length - 1; i++) {
                writer.println(names[i]);
            }
            writer.print(names[names.length - 1]);
            writer.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file");

        }
    }

    public static void main(String[] args) {
        String fileName, res;
        fileName = "C:\\Users\\coryr\\Desktop\\CSC499Part1\\Sort Me.txt";
        int lineNum = getFileSize(fileName); // Grabs filesize of the inputted file
        String[] names = getList(lineNum, fileName); // Grabs the list of words from inputted file to sort
        String[] tempNames = new String[lineNum];

        //Overrides built in function to sort by length of string
        Arrays.sort(names, (String a, String b) -> {
            return a.length() - b.length();
        });

        //Overrides built in array sort function to only sort them alphabetically if they are equal in length
        Arrays.sort(names, (String a, String b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return 0;
        });
        writeToFile(names);
        System.out.println("Write Successful");
    }
}
