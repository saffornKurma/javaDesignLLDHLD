package com.scalar;


import java.util.concurrent.atomic.AtomicInteger;

enum LEVEL{
    BEGINNER,
    INTERMEDIATE,
    PROFESSIONAL,
}


public class Enum {
    public static void main(String[] args) {

          AtomicInteger x= new AtomicInteger(10);

        Thread th=new Thread(()->{System.out.println(x.getAndIncrement());});

        th.start();
    }
}
