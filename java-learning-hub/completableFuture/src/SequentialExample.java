public class SequentialExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Fetch user details
        String userDetails = fetchUserDetails();  // Takes 2 seconds

        // Fetch user posts
        String userPosts = fetchUserPosts();  // Takes 3 seconds

        // Combine the results
        String combinedResult = userDetails + "\n" + userPosts;

        // Process the combined result
        System.out.println("Combined Result: \n" + combinedResult);
        long endTime = System.currentTimeMillis();
        long timeTakenInSeconds = (endTime - startTime) / 1000;

        System.out.println("Time taken: " + timeTakenInSeconds + " seconds");
    }

    private static String fetchUserDetails() {
        sleep(2000); // Simulate API call delay
        return "User Details: [Name: John, Age: 30]";
    }

    private static String fetchUserPosts() {
        sleep(3000); // Simulate API call delay
        return "User Posts: [Post 1, Post 2, Post 3]";
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

