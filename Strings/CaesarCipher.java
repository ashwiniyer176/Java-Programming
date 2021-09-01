package Strings;

import java.util.*;

public class CaesarCipher {
    public static StringBuffer Encryption(StringBuffer plainText, int rightShift) {
        for (int i = 0; i < plainText.length(); ++i) {
            char ch = plainText.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (((int) ch >= 90 - rightShift && (int) ch < 97) || (int) ch >= 122 - rightShift) {
                    ch = (char) ((int) ch - 26 + rightShift);
                } else {
                    ch = (char) ((int) ch + rightShift);
                }
            }
            plainText.setCharAt(i, ch);
        }
        return plainText;
    }

    public static StringBuffer Decryption(StringBuffer cipherText, int rightShift) {
        for (int i = 0; i < cipherText.length(); ++i) {
            char ch = cipherText.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if ((int) ch <= 65 + rightShift || (int) ch <= 97 + rightShift) {
                    ch = (char) ((int) ch + 26 - rightShift);
                } else {
                    ch = (char) ((int) ch - rightShift);
                }
            }
            cipherText.setCharAt(i, ch);
        }
        return cipherText;
    }

    public static void main(String[] args) {
        System.out.println("Enter Sentence:");
        Scanner in = new Scanner(System.in);
        StringBuffer plainText = new StringBuffer(in.nextLine());
        System.out.println("Enter Right Shift amount:");
        int rightShift = in.nextInt();
        plainText = Encryption(plainText, rightShift);
        System.out.println(plainText);
        StringBuffer cipherText = Decryption(plainText, rightShift);
        System.out.println(cipherText);

        in.close();
    }
}
