package Exception;

import java.util.*;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            int data = 5;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Rest of the code in finally");
        }
    }

}
