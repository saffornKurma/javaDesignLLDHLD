package com.scalar;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger number = new AtomicInteger(1);

        // Step 1: Main thread prints 1–10
        while (true) {
            int num = number.get();
            if (num > 10) break;
            System.out.println(Thread.currentThread().getName() + " printing " + number.getAndIncrement());
            Thread.sleep(100);
        }

        // Step 2: Start 4 threads to print 11–40
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(4); // To wait for 4 threads to finish

        Runnable worker = () -> {
            while (true) {
                int num = number.getAndIncrement();
                if (num > 40) break;

                try {
                    Thread.sleep(200); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println(Thread.currentThread().getName() + " printing " + num);
            }
            latch.countDown(); // signal this thread is done
        };

        // Submit exactly 4 worker threads
        for (int i = 0; i < 4; i++) {
            executor.submit(worker);
        }

        // Wait for all 4 threads to finish
        latch.await();
        executor.shutdown();

        // Step 3: Main thread prints 41–50
        while (true) {
            int num = number.get();
            if (num > 50) break;
            System.out.println(Thread.currentThread().getName() + " printing " + number.getAndIncrement());
            Thread.sleep(100);
        }
    }
}
