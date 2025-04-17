package com.scalar;



class OddAndEvenMethodSync {
    static int number = 1;
    static final Object lock = new Object();

    public  synchronized void printEven() throws InterruptedException {
        while (number <= 50) {
            while (number % 2 == 0) {
                System.out.println("Thread " + Thread.currentThread().getId() + " is even: " + number);
                number++;
                // Notify the other thread after printing even number
                this.notify();
            }
                // Wait until it is the correct turn to print even
                this.wait();

        }
    }

    public  synchronized void printOdd() throws InterruptedException {
        while (number <= 50) {
            while (number % 2 != 0) {
                System.out.println("Thread " + Thread.currentThread().getId() + " is odd: " + number);
                number++;
                // Notify the other thread after printing odd number
                this.notify();
            }
                // Wait until it is the correct turn to print odd
                this.wait();

        }
    }
}

public class ThreadOddAndEvenMethodSync {
    public static void main(String[] args) throws InterruptedException {

        OddAndEvenMethodSync obj=new OddAndEvenMethodSync();
        Thread th1 = new Thread(() -> {
            try {
                obj.printEven();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                obj.printOdd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }
}
