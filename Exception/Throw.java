package Exception;

public class Throw {
    public static void main(String[] args) {
        try {
            throw new Exception("Demo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
