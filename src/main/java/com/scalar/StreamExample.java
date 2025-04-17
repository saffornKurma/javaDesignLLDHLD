package com.scalar;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    static List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    public static void main(String[] args) {

        list.stream()
                .parallel()
                .map((i)->{
                    System.out.println("Thread: " + Thread.currentThread().getName()+" "+i);
                    return i;
                }).sequential()
                .map((i)->{
                    System.out.println("Thread: " + Thread.currentThread().getName()+" "+i);
                    return i;
                }).forEach((i)->{System.out.println("Thread: " + Thread.currentThread().getName()+" "+i);});

    }
}
