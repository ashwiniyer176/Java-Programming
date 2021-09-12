package OOP;

abstract class Bank {
    Bank(String title) {
        System.out.println(title + " Created");
        printBankDetails();
    }

    abstract void printBankDetails();

    abstract int getInterest();
}

class SBI extends Bank {
    SBI(String title) {
        super(title);
    }

    void printBankDetails() {
        System.out.println("State Bank of India");
    }

    int getInterest() {
        return 7;
    }
}

class PNB extends Bank {
    PNB(String title) {
        super(title);
    }

    void printBankDetails() {
        System.out.println("Punjab National Bank");
    }

    int getInterest() {
        return 8;
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Bank b;
        b = new SBI("SBI");
        System.out.println("SBI: " + b.getInterest());
        b = new PNB("PNB");
        System.out.println("PNB: " + b.getInterest());
    }

}
