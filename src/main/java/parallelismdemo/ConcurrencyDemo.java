package parallelismdemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        Counter count = new Counter(monitor);
        ExecutorService pool = Executors.newFixedThreadPool(1_000);
        for (int counter = 0; counter < 10_000; counter++) {
            pool.submit(() -> {
                try {
                    count.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(count.getCounter());
    }
}

class Counter {
    private int counter = 0;
    private Object monitor;

    public Counter(Object monitor) {
        this.monitor = monitor;
    }

    public void increment() throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock();
        synchronized (monitor) {
            if(counter <= 0) monitor.wait();
            counter++;
        }
        try {
            lock.readLock().lock();
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
        //heap.counter -> local
        //local = local + 1
        //local -> heap.counter;
    }
    public int getCounter() {
        return counter;
    }
}

//JMM: reordering visibility
class MyThread extends Thread {
    private boolean isStopped;

    public synchronized void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    @Override
    public synchronized void run() {
        while(true) {
            synchronized (this) {
                if(isStopped) return;
            }
        }
    }
}

class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5_000);
        myThread.setStopped(true);
    }
}