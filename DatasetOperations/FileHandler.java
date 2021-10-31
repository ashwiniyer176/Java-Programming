package DatasetOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {

    public static void main(String args[]) throws FileNotFoundException {
        File text = new File("C:/Users/Ashwin/Code/Java-Programming/DatasetOperations/data.csv");
        Scanner scnr = new Scanner(text);
        int totalNumbers = 1;
        while (scnr.hasNextLine()) {
            System.out.println("Line Number " + totalNumbers + "COntent is :- " + scnr.nextLine());
            totalNumbers++;
        }
        scnr.close();
    }
}