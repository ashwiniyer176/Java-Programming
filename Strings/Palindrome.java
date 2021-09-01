package Strings;

import java.util.*;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        boolean result = true;
        if (word.length() == 1 || (word.length() == 2 && word.charAt(0) == word.charAt(1))) {
            result = true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Enter word: ");
        Scanner in = new Scanner(System.in);
        String word = new String(in.next());
        System.out.println(isPalindrome(word.toLowerCase()));
        in.close();
    }
}
