public class GamePlatform {

    public double calculateSpeed(double initialSpeed, int[] inclinations) {
        double currentSpeed = initialSpeed;

        for (int angle : inclinations) {
            currentSpeed += angle > 0 ? -angle : Math.abs(angle);
            if (currentSpeed <= 0) return 0;
        }

        return Math.max(currentSpeed, 0);
    }

    public static void main(String[] args) {
        GamePlatform calculator = new GamePlatform();

        // Test case 1: Speed should be reduced to zero
        double initialSpeed1 = 10.0;
        int[] inclinations1 = {30, 30, 30}; // Total reduction = 90, so final speed = 0
        System.out.println("Test Case 1 - Final speed: " + calculator.calculateSpeed(initialSpeed1, inclinations1));

        // Test case 2: Speed should be adjusted by various inclines
        double initialSpeed2 = 100.0;
        int[] inclinations2 = {30, -45, 30, -45}; // Net effect: -30 + 45 - 30 + 45 = 30
        System.out.println("Test Case 2 - Final speed: " + calculator.calculateSpeed(initialSpeed2, inclinations2));

        // Test case 3: Speed should be increased
        double initialSpeed3 = 50.0;
        int[] inclinations3 = {-45, -45}; // Total increase = 90, so final speed = 140
        System.out.println("Test Case 3 - Final speed: " + calculator.calculateSpeed(initialSpeed3, inclinations3));

        // Test case 4: No inclines, speed remains unchanged
        double initialSpeed4 = 75.0;
        int[] inclinations4 = {}; // No inclines, speed should remain 75
        System.out.println("Test Case 4 - Final speed: " + calculator.calculateSpeed(initialSpeed4, inclinations4));
    }
}
