package com.scalar.LldDesignPatterns;


class Singleton {
    private static Singleton instance;


    private Singleton(){};

    public Singleton getInstance()
    {
        //DOUBLE CHECK SINGLETON
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
public class SingletonMain {
}
