package Threads;

class Multi extends Thread {
    public void run(String threadName) {
        System.out.println("Running thread " + threadName);
    }
}

public class ThreadTutorial {
    public static void main(String[] args) {
        System.out.println("Hello");
        Multi m1 = new Multi();
        m1.run("M1");
    }
}
