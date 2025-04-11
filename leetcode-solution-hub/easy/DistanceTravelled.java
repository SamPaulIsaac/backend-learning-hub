public class DistanceTravelled {
    public static void main(String[] args) {
        int mainTank = 5;
        int additionalTank = 1;
        int distance = 0;
        while (mainTank > 0) {
            if (mainTank < 5) {
                distance += mainTank * 10;
                mainTank = 0;
            } else {
                distance += 50;
                mainTank -= 5;
                if (additionalTank > 0) {
                    mainTank++;
                    additionalTank--;
                }
            }
        }
        System.out.println(distance);


    }
}
