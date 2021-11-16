import java.util.Scanner;

class Product {

    int num;
    int max;

    Product(int maxim) {
        max = maxim;
        num = (int) max * 9 / 10;
    }

    synchronized boolean consume(int cNumber) {
        if (num > 0) {
            num--;
            System.out.println("Consumer #" + cNumber + " consumed one (" + num + " left)");
            return true;
        }
        return false;
    }

    synchronized boolean produce(int pNumber) {
        if (num < max) {
            num++;
            System.out.println("Producer #" + pNumber + " produced one (" + num + " left)");
            return true;
        }
        return false;
    }
}

class Producer extends Thread {
    int made = 0;
    int pNumber;
    Product t;

    Producer(int num, Product stat) {
        pNumber = num;
        t = stat;
    }

    void makeNew() {
        if (t.produce(pNumber))
            made++;
        try {
            sleep(5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void inform() {
        System.out.println("Producer #" + pNumber + " noticed stack is full: (I made " + made + " myself)");
    }

    public void run() {
        while (t.num < t.max) {
            makeNew();
        }
        inform();
    }
}

class Consumer extends Thread {
    int took = 0;
    int cNumber;
    Product t;

    Consumer(int num, Product stat) {
        cNumber = num;
        t = stat;
    }

    void makeNew() {
        if (t.consume(cNumber))
            took++;
        try {
            sleep(5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void inform() {
        System.out.println("Consumer #" + cNumber + " noticed stack is empty: (I took " + took + " myself)");
    }

    public void run() {
        while (t.num > 0) {
            makeNew();
        }
        inform();
    }
}

public class ProducerConsumer {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int numOfProducts = sc.nextInt();
        System.out.print("Enter number of Producers: ");
        int nump = sc.nextInt();
        System.out.print("Enter number of Consumers: ");
        int numc = sc.nextInt();

        Product pr = new Product(numOfProducts);
        Thread p[] = new Thread[nump];
        Thread c[] = new Thread[numc];

        for (int i = 0; i < numc; i++) {
            c[i] = new Thread(new Consumer(i + 1, pr));
            c[i].start();
        }
        for (int i = 0; i < nump; i++) {
            p[i] = new Thread(new Producer(i + 1, pr));
            p[i].start();
        }
        for (int i = 0; i < numc; i++) {
            try {
                c[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        for (int i = 0; i < nump; i++) {
            try {
                p[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("All Done!");
        sc.close();
    }
}
