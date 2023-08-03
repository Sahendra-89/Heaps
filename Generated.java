import java.util.Random;
    import java.util.Scanner;
public class Generated {
    
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            boolean guessedCorrectly = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            
            while (!guessedCorrectly) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = scanner.nextInt();
                
                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                }
            }
            
            System.out.println("Thank you for playing the Number Guessing Game. Goodbye!");
        }
    }
        

