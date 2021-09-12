package Exception;

class NewException extends Exception {
    public NewException(String s) {
        super(s);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            throw new NewException("New Exception");
        } catch (NewException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
