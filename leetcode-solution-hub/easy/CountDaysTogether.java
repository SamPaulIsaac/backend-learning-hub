public class CountDaysTogether {
    public static void main(String[] args) {
        String arriveAlice = "04-20", leaveAlice = "06-18", arriveBob = "04-12", leaveBob = "12-19";
        System.out.println(countDaysTogetherOnSameMonth(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    static int countDaysTogetherOnSameMonth(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String latestArrival = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String earlyDeparture = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        System.out.println("Latest Arrival: " + latestArrival);
        System.out.println("Early Departure: " + earlyDeparture);
        if (latestArrival.compareTo(earlyDeparture) > 0) return 0;
        String arrivalMonth = latestArrival.substring(0, 2);
        String departureMonth = earlyDeparture.substring(0, 2);
        System.out.println("Is Same Month: " + isSameMonth(arrivalMonth, departureMonth));
        if (isSameMonth(arrivalMonth, departureMonth))
            return Integer.parseInt(earlyDeparture.substring(3)) - Integer.parseInt(latestArrival.substring(3)) + 1;
        else return calculatedDays(latestArrival, earlyDeparture, arrivalMonth, departureMonth);

    }

    private static int calculatedDays(String latestArrival, String earlyDeparture, String arrivalMonth, String departureMonth) {
        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int latestArrivalMonth = Integer.parseInt(arrivalMonth);
        int earlyDepartureMonth = Integer.parseInt(departureMonth);
        int daysCount = 0;
        daysCount += Integer.parseInt(earlyDeparture.substring(3));
        daysCount += daysInMonth[latestArrivalMonth - 1] - Integer.parseInt(latestArrival.substring(3));
        for (int i = latestArrivalMonth + 1; i < earlyDepartureMonth; i++) {
            daysCount += daysInMonth[i - 1];
        }
        return daysCount + 1;
    }

    static boolean isSameMonth(String arrivalMonth, String departureMonth) {
        return arrivalMonth.equals(departureMonth);
    }
}

