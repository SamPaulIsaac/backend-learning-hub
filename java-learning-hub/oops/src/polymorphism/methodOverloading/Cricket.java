package polymorphism.methodOverloading;

public class Cricket {
    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        cricket.team(11, 5, 1, 4, 1);
        System.out.println("\n");
        cricket.team(11, 5, 1, 5);
        System.out.println("\n");
        cricket.team(5, 11L, 1, 5);
    }

    public void team(Integer totalMembers, Integer batsman, Integer wicketKeeper,
                     Integer bowler, Integer allRounders) {
        System.out.println("Total Team Members : " + totalMembers + "\n"
                + "Total Batsmen : " + batsman + "\n"
                + "Wicket Keeper : " + wicketKeeper + "\n"
                + "Total Bowler : " + bowler + "\n"
                + "Total All Rounders : " + allRounders);
    }

    //below commented clashes with the above mentioned and preference will be given to the one which occur first
    /* public void team(Long totalMembers, Integer batsman, Integer wicketKeeper,
                     Integer bowler) {
        System.out.println("Total Team Members : " + totalMembers + "\n"
                + "Total Batsmen : " + batsman + "\n"
                + "Wicket Keeper : " + wicketKeeper + "\n"
                + "Total Bowler : " + bowler);

    } */

    public void team(Integer totalMembers, Integer batsman, Integer wicketKeeper,
                     Integer bowler) {
        System.out.println("Total Team Members : " + totalMembers + "\n"
                + "Total Batsmen : " + batsman + "\n"
                + "Wicket Keeper : " + wicketKeeper + "\n"
                + "Total Bowler : " + bowler);
    }

    public void team(Integer batsman, Long totalMembers, Integer wicketKeeper,
                     Integer bowler) {
        System.out.println("Total Team Members : " + totalMembers + "\n"
                + "Total Batsmen : " + batsman + "\n"
                + "Wicket Keeper : " + wicketKeeper + "\n"
                + "Total Bowler : " + bowler);

    }
}
