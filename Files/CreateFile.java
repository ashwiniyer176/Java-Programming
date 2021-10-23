package Files;

import java.io.*;

// Creating a file if it does not exist 
public class CreateFile {
    public static void main(String[] args) {
        try {
            File file = new File("file1.txt");
            if (file.createNewFile()) {
                System.out.println("File Created!");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
