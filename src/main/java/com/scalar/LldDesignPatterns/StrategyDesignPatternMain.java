package com.scalar.LldDesignPatterns;

// Strategy interface
interface EngineStrategy {
    void startingEngine();
}

// Concrete Strategy: Sports Engine
class SportsEngine implements EngineStrategy {
    @Override
    public void startingEngine() {
        System.out.println("Starting Sports Engine... Brrrrrrrrrrrr!");
    }
}

// Concrete Strategy: Normal Engine
class NormalEngine implements EngineStrategy {
    @Override
    public void startingEngine() {
        System.out.println("Starting Normal Engine... dak dak!");
    }
}

// Context class
abstract class Car {
    protected EngineStrategy engineStrategy;

    public Car(EngineStrategy engineStrategy) {
        this.engineStrategy = engineStrategy;
    }

    // Allow changing strategy at runtime
    public void setEngineStrategy(EngineStrategy engineStrategy) {
        this.engineStrategy = engineStrategy;
    }

    abstract void startEngineAndMove();
}

// Concrete Context: Sports Car
class SportsCar extends Car {
    public SportsCar() {
        super(new SportsEngine());
    }

    @Override
    void startEngineAndMove() {
        engineStrategy.startingEngine();
        System.out.println("SportsCar is zooming away!");
    }
}

// Concrete Context: Normal Car
class NormalCar extends Car {
    public NormalCar() {
        super(new NormalEngine());
    }

    @Override
    void startEngineAndMove() {
        engineStrategy.startingEngine();
        System.out.println("NormalCar is cruising smoothly.");
    }
}

// Main class to test the Strategy Pattern
public class StrategyDesignPatternMain {
    public static void main(String[] args) {
        Car car1 = new SportsCar();
        Car car2 = new NormalCar();

        System.out.println("=== Initial Engines ===");
        car1.startEngineAndMove();
        car2.startEngineAndMove();

        System.out.println("\n=== Changing Engine Strategy at Runtime ===");
        car1.setEngineStrategy(new NormalEngine());
        car1.startEngineAndMove();  // Now sports car behaves like a normal car
    }
}
