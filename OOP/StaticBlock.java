package OOP;

class StaticClass {
    static int i;
    int j;

    StaticClass() {
        j = 15;
        System.out.println(j + " from Constructor");
    }

    static {
        i = 10;
        System.out.println("Static block called");
    }
}

public class StaticBlock {
    public static void main(String[] args) {
        StaticClass s1 = new StaticClass();
        StaticClass s2 = new StaticClass();
    }
}
