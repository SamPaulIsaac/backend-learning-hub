import java.util.ArrayList;
import java.util.List;

// Subject interface that defines methods for attaching, detaching, and notifying observers
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Observer interface with an update method to be implemented by concrete observers
interface Observer {
    void update(int state);
}

// Concrete subject class that implements the Subject interface
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers(); // Notify observers when the state changes
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Concrete observer class that implements the Observer interface
class ConcreteObserver implements Observer {
    private final String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int state) {
        System.out.println(name + " received update. New state: " + state);
    }
}

// Example usage
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        // Attach observers to the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Change the state of the subject, and observers will be notified
        subject.setState(10);

        // Detach an observer
        subject.removeObserver(observer1);

        // Change the state again, and only observer2 will be notified
        subject.setState(20);
    }
}

