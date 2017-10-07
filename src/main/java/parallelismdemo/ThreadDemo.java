package parallelismdemo;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) {
        //Parallelism
        Thread remote = new Thread() {
            @Override
            public void run () {
                while(!Thread.interrupted()) {
                    Thread.currentThread().getName();
                    System.out.println("1111");
                }
            }
        };
        remote.start();
        remote.interrupt();
//        while (true) {
//            System.out.println("2222");
//        }


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t2.start();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(() -> {
            System.out.println("Hello1");
            System.out.println("Hello2");
            System.out.println("Hello3");
            System.out.println("Hello4");
        });

        Future<Integer> futureResult = pool.submit(new Callable<Integer>() {
           @Override
           public Integer call () throws Exception {
               return 2+2;
           }
        });
        futureResult.isDone();
        try {
            System.out.println(futureResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //Concurrency
    }
}
