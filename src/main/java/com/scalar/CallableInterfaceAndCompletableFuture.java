package com.scalar;

import java.util.concurrent.*;

public class CallableInterfaceAndCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FUTURE AND CALLABLE
/*
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> future=executorService.submit(()->{
            return 100;
        });

        if(future.isDone())
        {
            System.out.println(future.get());
        }
        else {
            System.out.println("waiting "+future.get());
        }

        executorService.shutdown();
*/

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "pizza Ready";});

        future.thenApply((S)->{ return S+" Coke ready" ;}).thenAccept(System.out::println);




    }


}
