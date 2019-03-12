package thread;

public class Sales implements Runnable {
    private Tickets tickets;
    private int count = 0;
    private long interval;
    private String channel;

    public Sales(Tickets tickets, String channel, long interval) {
        this.tickets = tickets;
        this.channel = channel;
        this.interval = interval;
    }

    public int getCount() {
        return this.count;
    }

    public synchronized void sell() {
        this.tickets.sellTicket();
        this.count += 1;
    }

    @Override
    public void run() {
        while (this.tickets.getTickets() > 0) {
            this.sell();
            try {
                Thread.sleep(this.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("通过" + this.channel + "售出了" + this.count + "张火车票。");
    }
}
