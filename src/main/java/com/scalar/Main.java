package com.scalar;



abstract class Animal
{
 abstract void makSound();

}

abstract class  Dog extends Animal
{
    void makeSound()
    {
        System.out.println("Dog");
    }
}

 class  Indie extends Dog
{
    void makeSound()
    {
        System.out.println("Dog");
    }

    @Override
    void makSound() {
        System.out.println("Indie");
    }
}
public class Main {
    public static void main(String[] args) {
Animal animal = new Indie();
animal.makSound();
    }
}