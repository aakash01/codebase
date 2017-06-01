package com.aakash.personal.concurrency;

/**
 * Created by a0n007d on 27/02/17.
 */
public class Test3 {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println("Started thread");
            Thread t2 = new Thread(() -> {
                System.out.println("Started Child thread");
                for (int i=0;i<10;i++) {
                    System.out.println("[non daemon thread] " + i);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t2.setDaemon(false);
            t2.start();
            for (int i=0;i<10;i++) {
                System.out.println("[thread] " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        for (int i=0;i<10;i++) {
            System.out.println("[main thread] " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
