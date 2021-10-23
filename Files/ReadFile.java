package Files;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) {
        String path = ("C:/Users/Ashwin/Code/Java-Programming/file.txt");
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}