package com.scalar.LldDesignPatterns;

import java.util.ArrayList;
import java.util.List;

// Observable interface
interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void setData(int data);
}

// Observer interface
interface Observer {
    void update(int stock);
}

// Concrete Observable: Iphone store
class Iphone implements Observable {
    private List<Observer> listOfSubscription;
    private int stock;

    public Iphone() {
        listOfSubscription = new ArrayList<>();
        stock = 0;
    }

    @Override
    public void add(Observer observer) {
        listOfSubscription.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        listOfSubscription.remove(observer);
    }

    @Override
    public void setData(int data) {
        boolean wasOutOfStock = (stock == 0);
        stock = data;

        if (wasOutOfStock && stock > 0) {
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (Observer observer : listOfSubscription) {
            observer.update(stock);
        }
    }
}

// Concrete Observer: Email Notification
class Email implements Observer {
    private String email;
    private String name;

    public Email(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public void update(int stock) {
        System.out.println("Email Notification to " + name + " (" + email + "): iPhone is back in stock! Available: " + stock);
    }
}

// Concrete Observer: SMS Notification
class Sms implements Observer {
    private long number;
    private String name;

    public Sms(long number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public void update(int stock) {
        System.out.println("SMS Notification to " + name + " (" + number + "): iPhone is back in stock! Available: " + stock);
    }
}

// Main class to test Observer pattern
public class ObserverDesignPatternMain {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        // Create and add observers
        Email emailObserver = new Email("Shree@onemail.com", "Satish");
        Sms smsObserver = new Sms(98766353243L, "Mahesh");

        iphone.add(emailObserver);
        iphone.add(smsObserver);

        System.out.println("=== Trying to add stock ===");
        iphone.setData(10);  // Notification triggered

        System.out.println("\n=== Removing one observer and restocking ===");
        iphone.remove(emailObserver);
        iphone.setData(20);  // Only SMS observer will be notified
    }
}
