package com.aakash.personal.concurrency;

import java.util.concurrent.*;

/**
 * Created by a0n007d on 28/02/17.
 */
public class AdderHelper {

    static String[] infiles = new String[]{"/Users/a0n007d/Desktop/in1.txt","/Users/a0n007d/Desktop/in2.txt","/Users/a0n007d/Desktop/in3.txt","/Users/a0n007d/Desktop/in4.txt","/Users/a0n007d/Desktop/in5.txt","/Users/a0n007d/Desktop/in6.txt"};
    static String[] outfiles = new String[]{"/Users/a0n007d/Desktop/out1.txt","/Users/a0n007d/Desktop/out2.txt","/Users/a0n007d/Desktop/out3.txt","/Users/a0n007d/Desktop/out4.txt","/Users/a0n007d/Desktop/out5.txt","/Users/a0n007d/Desktop/out6.txt"};

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread[] workerThreads = new Thread[infiles.length];
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer>[] futures = new Future[6];
        for(int i=0;i<infiles.length;i++){
            futures[i] = executor.submit(new Adder(infiles[i]));
        }
        int i=0;
        for(Future<Integer> future : futures){
            try {
                Integer output = future.get();
                System.out.println("Total for "+ infiles[i]+ " "+output);
            } catch (ExecutionException e) {
                System.out.println("Exception occured " + e.toString());
            }
            i++;
        }
        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("Total time taken: " + (System.currentTimeMillis() - start) + " msecs");
    }
}
