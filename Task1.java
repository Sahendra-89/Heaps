   import java.util.Random;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + (rounds + 1));
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < randomNumber) {
                    System.out.println("Too low! Guesses remaining: " + (maxAttempts - attempts));
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Guesses remaining: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    int score = maxAttempts - attempts + 1;
                    totalScore += score;
                    System.out.println("Score for this round: " + score);
                    guessedCorrectly = true;
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The number was: " + randomNumber);
            }
            
            rounds++;
            
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("Y");
        }
        
        System.out.println("\nThank you for playing the Number Guessing Game!");
        System.out.println("Total Rounds played: " + rounds);
        System.out.println("Total Score: " + totalScore);
    }
}

    

