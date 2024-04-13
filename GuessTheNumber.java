import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerNumber = 1;
        int upperNumber = 100;
        int maxAttempts = 10;
        int totalScore = 0;

        System.out.println("Welcome to Guess the Number: ");
        System.out.println("I've picked a number between: " + lowerNumber + " and " + upperNumber + ". Try to guess it.");

        while (true) {
            int targetNumber = random.nextInt(upperNumber - lowerNumber + 1) + lowerNumber;
            int attempts = 0;

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuessing = scanner.nextInt();//25
                attempts++;

                if (userGuessing == targetNumber) {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Round score: " + roundScore);
                    break;
                } else if (userGuessing < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts >= maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was " + targetNumber + ".");
                    break;
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Total score across rounds: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}