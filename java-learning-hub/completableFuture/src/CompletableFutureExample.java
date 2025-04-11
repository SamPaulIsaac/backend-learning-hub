package src;

import java.util.concurrent.CompletableFuture;

//import static java.lang.StringTemplate.STR;


public class CompletableFutureExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Asynchronously fetch user details
        // Simulate API call to fetch user details
        CompletableFuture<String> userDetailsFuture = CompletableFuture.supplyAsync(CompletableFutureExample::fetchUserDetails);

        // Asynchronously fetch user posts
        // Simulate API call to fetch user posts
        CompletableFuture<String> userPostsFuture = CompletableFuture.supplyAsync(CompletableFutureExample::fetchUserPosts);

        // Combine the results of both futures
        CompletableFuture<String> combinedFuture = userDetailsFuture.thenCombine(userPostsFuture, (userDetails, userPosts) -> {
            return userDetails + "\n" + userPosts;
        });

        // Process the combined result
//        combinedFuture.thenAccept(combinedData -> {
//            System.out.println(STR."""Combined Result:\s\{combinedData}""");});

        // Wait for all futures to complete
        combinedFuture.join();

        long endTime = System.currentTimeMillis();
        long timeTakenInSeconds = (endTime - startTime) / 1000;

        System.out.println("Time taken: " + timeTakenInSeconds + " seconds");
    }

    private static String fetchUserDetails() {
        // Simulating a delay as if fetching from an API
        sleep(2000);
        return "User Details: [Name: John, Age: 30]";
    }

    private static String fetchUserPosts() {
        // Simulating a delay as if fetching from an API
        sleep(3000);
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
