package inheritance.single;

class Country {
    public String getName() {
        return "Country.";
    }
}

class India extends Country {

    public String name() {
        return "Country - India.";
    }
}

class USA extends Country {

    public String name() {
        return "Country - USA.";
    }
}

public class Single {
    public static void main(String[] args) {
        India india = new India();
        System.out.println(india.name());
        USA usa = new USA();
        System.out.println(usa.name());
    }
}
