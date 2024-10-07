import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        
        int maxRange = 100; 
        int maxAttempts = 5; 
        int roundsWon = 0; 
        boolean playAgain;
        
        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = rm.nextInt(maxRange) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nA new round has started!");
            System.out.println("I have picked a number between 1 and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int userGuess = sc.nextInt();
                
                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                }
                
                attemptsLeft--;
                
                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("You have " + attemptsLeft + " attempt(s) left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've run out of attempts. The correct number was: " + targetNumber);
            }
            
        
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        
        System.out.println("\nGame Over! You won " + roundsWon + " round(s).");
        System.out.println("Thanks for playing!");
        
        sc.close();
    }
}