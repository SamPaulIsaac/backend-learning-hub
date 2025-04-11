package inheritance.multiple;

interface Batting {
    String bat();
}

interface Bowling {
    String bowl();
}

class Batter implements Batting {

    @Override
    public String bat() {
        return "Bats";
    }
}

class Bowler implements Bowling {

    @Override
    public String bowl() {
        return "Bowls";
    }
}

class AllRounder implements Batting, Bowling {

    @Override
    public String bat() {
        return "Bats";
    }

    @Override
    public String bowl() {
        return "Bowls";
    }
}

public class Multiple {
    public static void main(String[] args) {

        Batter virat = new Batter();
        System.out.println("Virat:" + virat.bat());
        Bowler bumrah = new Bowler();
        System.out.println("Bumrah:" + bumrah.bowl());
        AllRounder jadeja = new AllRounder();
        System.out.println("Jadeja: " + jadeja.bat() + " and " + jadeja.bowl());

    }
}
