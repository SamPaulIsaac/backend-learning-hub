import designSnakeAndLadder.exception.InvalidUserInputException;

import java.io.IOException;
import java.util.*;


public class SnakeAndLadderService {
    static final String INVALID_USER_INPUT_EXCEPTION = "Incorrect User Input. Please re-enter.";
    static final Integer MAX_LIMIT = 100;
    static Map<Integer, Integer> snakes = new HashMap<>();
    static Map<Integer, Integer> ladders = new HashMap<>();
    Scanner userInput = new Scanner(System.in);

    public void startTheGame() throws IOException {
        int playerCount = 0;

        try {
            // Get the user input for player count
            System.out.println("-----------------------------------------------------------");
            System.out.println("Please enter the number of users to be playing the game : ");
            playerCount = userInput.nextInt();
            System.out.println("-----------------------------------------------------------");
            System.out.println("Please enter the number of snakes to be used in the game : ");
            int snakeCount = userInput.nextInt();
            System.out.println("-----------------------------------------------------------");
            for (int snake = 1; snake <= snakeCount; snake++) {
                System.out.println("Please enter the header and tail position for snake " + snake + " comma separated: ");
                String headAndTailPosition = userInput.next();
                String[] value = headAndTailPosition.split(",");
                snakes.put(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            }
            System.out.println("-----------------------------------------------------------");
            System.out.println("Please enter the number of ladders to be used in the game : ");
            int ladderCount = userInput.nextInt();
            System.out.println("-----------------------------------------------------------");
            for (int ladder = 1; ladder <= ladderCount; ladder++) {
                System.out.println("Please enter the start and end position for ladder " + ladder + " comma separated: ");
                String startAndEndPosition = userInput.next();
                String[] value = startAndEndPosition.split(",");
                ladders.put(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            }
            System.out.println("-----------------------------------------------------------");
        } catch (InputMismatchException invalidUserInputException) {
            throw new InvalidUserInputException(INVALID_USER_INPUT_EXCEPTION);
        }

        int[] squarePosition = new int[playerCount];

        // Initialising the start position of all the players to 1
        for (int i = 0; i < playerCount; i++) {
            squarePosition[i] = 1;
        }

        while (true) {
            for (int player = 0; player < playerCount; player++) {
                System.out.println("Player " + (player + 1) + " is in play.");
                System.out.println("Press Enter to roll a dice");
                int returnedValue = System.in.read();
                int value = rollDice();
                System.out.println("Player " + (player + 1) + " rolls a  " + value);
                System.out.println("-----------------------------------------------------------");
                int calculatedValue = calculate(squarePosition[player], value, (player + 1));
                if (calculatedValue == MAX_LIMIT) {
                    System.out.println("Player " + (player + 1) + " moved from " + squarePosition[player] + " to " + MAX_LIMIT);
                    System.out.println("Player " + (player + 1) + " wins");
                    System.out.println("-----------------------------------------------------------");
                    return;
                }
                squarePosition[player] = calculatedValue;
            }
        }


    }

    private int calculate(int squarePosition, int value, int player) {

        int newSquarePositionToBeMoved = squarePosition + value;

        if (newSquarePositionToBeMoved == MAX_LIMIT) {
            return newSquarePositionToBeMoved;
        } else if (newSquarePositionToBeMoved > MAX_LIMIT) {
            System.out.println("Player cannot move as it exceeds max limit, try again!");
            System.out.println("-----------------------------------------------------------");
            return squarePosition;
        } else {
            if (null != snakes.get(newSquarePositionToBeMoved)) {
                System.out.println("Encountered a SNAKE!, it's unfortunate, you want to make a way back down.");
                System.out.println("Player " + player + " moved from " + squarePosition + " to " + snakes.get(newSquarePositionToBeMoved));
                System.out.println("-----------------------------------------------------------");
                return snakes.get(newSquarePositionToBeMoved);
            }
            if (null != ladders.get(newSquarePositionToBeMoved)) {
                System.out.println("Encountered a LADDER! Now Move Fast.");
                System.out.println("Player " + player + " moved from " + squarePosition + " to " + ladders.get(newSquarePositionToBeMoved));
                System.out.println("-----------------------------------------------------------");
                return ladders.get(newSquarePositionToBeMoved);
            } else {
                System.out.println("Player " + player + " moved from " + squarePosition + " to " + newSquarePositionToBeMoved);
                System.out.println("-----------------------------------------------------------");
                return newSquarePositionToBeMoved;
            }
        }
    }

    private int rollDice() {
        Random random = new Random();
        int value = random.nextInt(7);
        return value == 0 ? 1 : value;
    }

}
