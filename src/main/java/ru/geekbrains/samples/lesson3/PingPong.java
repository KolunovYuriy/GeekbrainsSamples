package ru.geekbrains.samples.lesson3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong implements Runnable {

    private static final int COUNT = (int) (1000 * Math.random());
    private static final Lock lock = new ReentrantLock();
    private static final String PING_ACTION = "ping";
    private static final String PONG_ACTION = "pong";
    private static volatile int inc = 0;
    private static volatile String currentAction = PONG_ACTION;
    /**
     * без volatile отработает также при использовании Lock
     */
//    private static int inc = 0;
//    private static String currentAction = PONG_ACTION;

    public static void main(String[] args) {
        PingPong ping = new PingPong();
        PingPong pong = new PingPong();
        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("COUNT = " + COUNT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (inc<COUNT)
        {
            try {
                lock.lock();
                System.out.println("hit " + (++inc) + " " + this.getAction());
                Thread.sleep((int) (10 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public String getAction() {
        currentAction = currentAction.equals(PING_ACTION) ? PONG_ACTION : PING_ACTION;
        return currentAction;
    }
}
