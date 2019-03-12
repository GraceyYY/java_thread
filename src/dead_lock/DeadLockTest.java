package dead_lock;


class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        String firstChopsticks = "第一支筷子";
        String secondChopsticks = "第二支筷子";

        //解决方法一：修改加锁的顺序。当两个线程加锁的顺序是一致的时候，不会出现死锁的情况。
        Thread t1 = new Thread(new DeadLockThread(firstChopsticks, secondChopsticks), "甲");
        Thread t2 = new Thread(new DeadLockThread(firstChopsticks, secondChopsticks), "乙");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
    }
}
