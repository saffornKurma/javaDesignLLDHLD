package com.scalar.LldDesignPatterns;

// Base component
abstract class BasePizza {
    abstract double cost();
    abstract String getDescription();
}

// Concrete base pizza: Margerita
class Margerita extends BasePizza {
    @Override
    double cost() {
        return 200.00;
    }

    @Override
    String getDescription() {
        return "Margerita";
    }
}

// Concrete base pizza: Farmhouse
class Farmhouse extends BasePizza {
    @Override
    double cost() {
        return 250.00;
    }

    @Override
    String getDescription() {
        return "Farmhouse";
    }
}

// Abstract decorator
abstract class ToppingDecorator extends BasePizza {
    protected BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete decorator: Extra Cheese
class ExtraCheese extends ToppingDecorator {
    public ExtraCheese(BasePizza pizza) {
        super(pizza);
    }

    @Override
    double cost() {
        return pizza.cost() + 100.00;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }
}

// Concrete decorator: Mushroom
class Mushroom extends ToppingDecorator {
    public Mushroom(BasePizza pizza) {
        super(pizza);
    }

    @Override
    double cost() {
        return pizza.cost() + 80.00;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + " + Mushroom";
    }
}

// Test class
public class DecoratorDesignPatternMain {
    public static void main(String[] args) {
        // Build a pizza with Margerita + Extra Cheese + Mushroom
        BasePizza myPizza = new Mushroom(new ExtraCheese(new Margerita()));

        System.out.println("Pizza: " + myPizza.getDescription());
        System.out.println("Total Cost: ₹" + myPizza.cost());

        // Another example: Farmhouse + Mushroom
        BasePizza anotherPizza = new Mushroom(new Farmhouse());
        System.out.println("\nPizza: " + anotherPizza.getDescription());
        System.out.println("Total Cost: ₹" + anotherPizza.cost());
    }
}
