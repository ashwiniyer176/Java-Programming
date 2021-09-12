package Exception;

public class Throws {
    static void except() throws IllegalAccessException {
        System.out.println("Inside except()");
        throw new IllegalAccessException("Demo");
    }

    public static void main(String[] args) {
        try {
            except();
        } catch (IllegalAccessException e) {
            System.out.println(e + " Caught in main");
        }
    }
}
