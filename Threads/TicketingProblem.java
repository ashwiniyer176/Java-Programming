package Threads;

class Ticket {
    int tickets = 50;
}

class Counter extends Thread {
    int ticketsSold;
    String counterName;

    Counter(String counterName) {
        this.ticketsSold = 0;
        this.counterName = counterName;
    }

    public void run(Ticket ticket) {
        if (ticket.tickets > 0) {
            synchronized (ticket) {
                System.out.println(this.counterName + " sold one (" + --ticket.tickets + " left) ");
                this.ticketsSold++;
            }
            try {
                sleep((long) (Math.random() * 100));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void start(Ticket ticket) {
        run(ticket);
    }

    public void report() {
        System.out.println(this.counterName + " sold " + this.ticketsSold);
    }

}

public class TicketingProblem {

    public static void main(String[] args) {
        Ticket tickets = new Ticket();
        Counter c1 = new Counter("Seller 1");
        Counter c2 = new Counter("Seller 2");
        Counter c3 = new Counter("Seller 3");
        Counter c4 = new Counter("Seller 4");
        while (tickets.tickets > 0) {
            c1.run(tickets);
            c2.run(tickets);
            c3.run(tickets);
            c4.run(tickets);
        }
        c1.report();
        c2.report();
        c3.report();
        c4.report();
    }
}
