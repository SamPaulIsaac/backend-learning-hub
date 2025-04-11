public class CountMatchesInTournament {
    public static void main(String[] args) {
        int team = 14;
        int matchesCount = 0;
        int match;
        while (team > 1) {
            if (team % 2 != 0) match = (team - 1) / 2;
            else match = team / 2;
            team -= match;
            matchesCount += match;
        }
        System.out.println("Match Count: " + matchesCount);
    }
}
