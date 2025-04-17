package com.scalar;


class Singleton {
    private static Singleton newInstance;
    public static Singleton getInstance() {
        if (newInstance == null) {
            synchronized (Singleton.class) {
                if (newInstance == null) {
                    newInstance = new Singleton();
                }
            }
        }
        return newInstance;
    }
}
public class SingletonExample {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();

    }
}
