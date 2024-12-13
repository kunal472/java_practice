import java.util.*;

public class NumberGuessing
{public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    Random random = new Random();
    boolean playAgain =true;
    int totalScore = 0;
    int roundNumber =0;

    System.out.println("Welcome to the Guessing game of number??");
    System.out.println("Guess the number between 1 and 100.");

    while (playAgain)
    {
        roundNumber++;
        int generatedNumber = random.nextInt(100)+1; //number generation
        int attemptRemaining = 10;
        System.out.println("\n---  Round "+ roundNumber +"---");
        System.out.println("You have 10 atempts fo guessing ");

        boolean guessedCorrectly = false;
        while (attemptRemaining > 0) {
            System.out.println("Enter your guess("+ attemptRemaining +"attempts left): ");
            int guess;
            try {
                guess = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            if (guess<1|| guess> 100) {
                System.out.println("Your guess is Out Of Range! Please guess between 1 and 100");
                continue;
            }
            
            attemptRemaining--;

            if (guess == generatedNumber) {
                System.out.println("Congratulations! you guessed the correct number.");
                totalScore += attemptRemaining+1;
                guessedCorrectly = true;
                break;
                } 
            
            else if (guess < generatedNumber) {
                System.out.println("Too low! try again.!");
                }
            else{
                System.out.println("Too high! try again.!");
                }

            if (!guessedCorrectly){
                System.out.println("Game over! the correct number was "+ generatedNumber +".");
                }
            
            System.out.println("Your total score so far is: "+ totalScore);
            System.out.println("Do you want to play another round? (yes or no)");
            String playAgainInput = s.nextLine().trim().toLowerCase();
            if (!playAgainInput.equals("yes") && !playAgainInput.equals("y")){
                playAgain = false;
            }
        }
            System.out.println("Thank you for playing! Your final scores is: " + totalScore);   
            s.close();  
    }
}}