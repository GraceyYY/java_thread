package thread;

public class Main {
    public static void main(String[] args) {
        Tickets tickets = new Tickets(500);
        Thread station = new Thread(new Sales(tickets, "火车站窗口", 1000), "火车站");
        Thread web = new Thread(new Sales(tickets, "12306官网", 10000), "官网");
        Thread app = new Thread(new Sales(tickets, "携程APP", 5000), "携程");

        station.start();
        web.start();
        app.start();

        try {
            station.join();
            web.join();
            app.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
