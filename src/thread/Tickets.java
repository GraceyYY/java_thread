package thread;

public class Tickets {
    private int tickets;


    public Tickets(int tickets) {
        this.tickets = tickets;
    }

    public synchronized void sellTicket() {
        this.tickets -= 1;
    }

    public int getTickets() {
        return this.tickets;
    }

}