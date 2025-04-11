package inheritance.multiLevel;

class India {
    public String name() {
        return "India.";
    }
}

class State extends India {
    public String name() {
        return "TamilNadu." + super.name();

    }
}

class City extends State {
    public String name() {
        return "Coimbatore is the city, which is present in " + super.name();
    }
}

public class Multilevel {
    public static void main(String[] args) {
        City coimbatore = new City();
        System.out.println(coimbatore.name());
    }
}
