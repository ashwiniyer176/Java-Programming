package OOP;

interface printable {
    void printBankDetails();
}

interface showable {
    int showBankDetails();
}

class StateBank implements printable, showable {

    public void printBankDetails() {
        System.out.println("State Bank of India");
    }

    public int showBankDetails() {
        return 7;
    }
}

class PunjabBank implements printable, showable {
    public void printBankDetails() {
        System.out.println("Punjab National Bank");
    }

    public int showBankDetails() {
        return 8;
    }
}

public class Interface {
    public static void main(String[] args) {
        StateBank s = new StateBank();
        PunjabBank p = new PunjabBank();
        s.printBankDetails();
        System.out.println("ROI: " + s.showBankDetails());
        p.printBankDetails();
        System.out.println("ROI: " + p.showBankDetails());
    }
}