package com.scalar;


 class OddAndEven
{
    static int number=1;
    static final Object lock = new Object();

    public static void printEven() throws InterruptedException {
        while(number<=50)
        {
            synchronized (lock)
            {
                while (number%2!=0) {
                    lock.wait();
                }

                System.out.println("Thread " + Thread.currentThread().getId() + " is Even"+" number="+number);
                number++;
                lock.notify();
            }


        }

    }

    public static void printOdd() throws InterruptedException {
        while(number<=50)
        {
            synchronized (lock)
            {
                while (number%2==0) {
                    lock.wait();
                }

                System.out.println("Thread " + Thread.currentThread().getId() + " is Odd"+" number="+number);
                number++;
                lock.notify();
            }

        }

    }
}
public class ThreadingOddAndEven {
     public static void main(String[] args) throws InterruptedException {


         Thread th1=new Thread(()->{
             try{
                 OddAndEven.printEven();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
         });
         Thread th2=new Thread(()->{
             try{
                 OddAndEven.printOdd();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
         });

         th1.start();
         th2.start();

         th1.join();
         th2.join();
     }
}
