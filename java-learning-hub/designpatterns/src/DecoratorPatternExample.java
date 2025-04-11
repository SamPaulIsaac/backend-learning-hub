// Component interface
interface Coffee {
    String getDescription();

    double cost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

// Decorator abstract class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete decorator 1
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }
}

// Concrete decorator 2
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Simple Coffee: " + simpleCoffee.getDescription() + ", Cost: $" + simpleCoffee.cost());

        // Add milk to the coffee
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Milk Coffee: " + milkCoffee.getDescription() + ", Cost: $" + milkCoffee.cost());

        // Add sugar to the coffee
        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Sweet Coffee: " + sweetCoffee.getDescription() + ", Cost: $" + sweetCoffee.cost());
    }
}

