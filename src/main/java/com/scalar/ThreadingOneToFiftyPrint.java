package com.scalar;

import java.util.ArrayList;
import java.util.List;

public class ThreadingOneToFiftyPrint {

    static int element=0;
    private final static Object lock = new Object();

    static void printElement()
    {
        synchronized(lock)
        {
            if(element>50) return;
            element++;
            System.out.println("Thread "+Thread.currentThread().getName()+": "+element);
        }

    }

    public static void main(String[] args) throws InterruptedException {


        while(element<10)
        {
            printElement();
        }

        List<Thread> threads = new ArrayList<>();
        int numberOfThreads = 4;
            for(int i=0;i<numberOfThreads;i++)
            {
                threads.add(new Thread(()->{
                   while(true)
                   {
                       synchronized (lock){
                           if(element>=40) break;
                           printElement();
                       }

                       try
                       {
                           Thread.sleep(1);
                       }
                       catch (InterruptedException e)
                       {
                           e.printStackTrace();
                       }

                   }
                }));

                threads.get(i).start();
            }

            for(int i=0;i<numberOfThreads;i++)
            {
                threads.get(i).join();
            }

        while(element<50)
        {
            printElement();
        }

    }
}
