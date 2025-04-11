// Step 1: Create an interface or an abstract class for the product
interface Product {
    void display();
}

// Step 3: Create a factory interface or an abstract class
interface ProductFactory {
    Product createProduct();
}

// Step 2: Create concrete classes that implement the product interface
class ConcreteProductA implements Product {
    @Override
    public void display() {
        System.out.println("Concrete Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void display() {
        System.out.println("Concrete Product B");
    }
}

// Step 4: Create concrete factories that implement the factory interface
class ConcreteProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductBFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// Step 5: Client code uses the factory to create objects
public class FactoryPatternExample {
    public static void main(String[] args) {
        // Using the factory to create objects
        ProductFactory factoryA = new ConcreteProductAFactory();
        Product productA = factoryA.createProduct();
        productA.display();

        ProductFactory factoryB = new ConcreteProductBFactory();
        Product productB = factoryB.createProduct();
        productB.display();
    }
}

