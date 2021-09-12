package Exception;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            int[] a = new int[5];
            a[15] = 5 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("Dividing by zero");
        }
    }
}
