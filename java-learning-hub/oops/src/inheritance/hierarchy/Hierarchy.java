package inheritance.hierarchy;

class Country {
    public String name() {
        return "Country - India.";
    }
}

class State extends Country {
    public String name() {
        return "State - Tamil Nadu.";
    }
}

class UnionTerritory extends Country {
    public String name() {
        return "Union Territory - Pondicherry.";
    }
}

public class Hierarchy {
    public static void main(String[] args) {
        State state = new State();
        System.out.println(state.name());
        UnionTerritory unionTerritory = new UnionTerritory();
        System.out.println(unionTerritory.name());
    }
}
