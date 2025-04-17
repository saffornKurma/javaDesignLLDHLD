package com.scalar;


import java.util.LinkedList;
import java.util.Queue;

class SharedResource {

    int counter = 0;
    public Queue<Integer> queue=new LinkedList<>();

    public synchronized void add() throws InterruptedException {

        if(counter>=20) {return;}
            while(queue.size()>=20) {

                System.out.println("Thread"+Thread.currentThread().getId()+" is waiting for 220");
                wait();
            }

            queue.add(++counter);
            System.out.println("Thread"+Thread.currentThread().getId()+" produced "+counter);
            notifyAll();




    }

    public synchronized void consume() throws InterruptedException {


            while(queue.isEmpty()) {
                System.out.println("Thread"+Thread.currentThread().getId()+" waiting to consume");
                wait();
            }
            System.out.println("Thread"+Thread.currentThread().getId()+" consuming "+queue.poll());
            //queue.remove();
            notifyAll();
        }


}
public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource=new SharedResource();

        int i=0;

        Thread producer=new Thread(()->{
            while(true)
            {
                try {
                    Thread.sleep(1000);
                    sharedResource.add();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        Thread consumer=new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(1);
                    sharedResource.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
