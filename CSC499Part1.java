
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Scanner;

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
                if (!line.isEmpty()) {
                    nameList[i] = line.trim();//Trims off any whitespace found in file
                    i++;
                }
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
    static int getFileSize(File file) {
        int numOfLines = 0;
        try {

            if (file.exists()) {

                String line = "";
                FileReader fr = new FileReader(file);
                LineNumberReader lineReader = new LineNumberReader(fr);

                //Stops when there are no lines left in file
                while ((line = lineReader.readLine()) != null) {
                    if (!line.isEmpty()) {
                        numOfLines++;
                    }
                }

                lineReader.close();
            }
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + file + "'");

        }
        return numOfLines;
    }

    //Writes newly sorted array to file
    static void writeToFile(String[] names, String outputDir) {
        try {
            PrintWriter writer = new PrintWriter(outputDir + ".txt", "UTF-8");
            for (int i = 0; i <= names.length - 1; i++) {
                if (names[i].length() > 0) {
                    writer.println(names[i]);
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file");
            System.exit(1);
        }
    }

    //Sorts the names by length
    static void sortLength(String[] names, char order) {
        if (order == 'd') {
            Arrays.sort(names, (String a, String b) -> {
                return b.length() - a.length();
            });
        } else {
            Arrays.sort(names, (String a, String b) -> {
                return a.length() - b.length();
            });
        }

    }

    //Sorts names that are the same length alphabetically
    static void sortAlphabetically(String[] names) {
        Arrays.sort(names, (String a, String b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return 0;
        });
    }

    static void sortList(String[] names, char order) {
        sortLength(names, order);
        sortAlphabetically(names);

    }

    //Checks if file to sort exists
    static void checkFile(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileName = "", outputFile = "";
        char order = 'a';
        File file = null;
        System.out.println(args.length);
        //If program is ran through IDE
        if (args.length == 0) {
            System.out.println("Entered no arguments");
            System.exit(1);
        } else {//If ran through cmd
            fileName = args[0];
            file = new File(args[0]);
            outputFile = args[1];
            if (args.length == 3) {
                order = args[2].charAt(0);//If incorrect input Ascending order is assumed
            }
        }
        System.out.println(order);
        //Checks if file exists
        checkFile(file);

        int lineNum = getFileSize(file); // Grabs filesize of the inputted file
        String[] names = getList(lineNum, fileName); // Grabs the list of words from inputted file to sort
        sortList(names, order);
        writeToFile(names, outputFile);
        System.out.println("Write Successful");
    }
}
