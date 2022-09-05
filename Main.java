import java.util.Random;
//Used to determine pseudorandom computer move.
import java.util.Scanner;
//Used to take in user's input.

public class Main {
    public static void main(String[] args) {

        int userScore = 0, computerScore = 0;
        //Variables used to display final score.
        String userInput;
        //Variable used to track user's move to play or choice to quit.
        int randomNum;
        //Variable used to determine pseudorandom computer move.
        String cheatInput;
        //Variable used to track user's choice to cheat or not cheat.
        final int scoreDifferenceForCheats = 5;
        //Variable used to determine how many points behind user must be for the cheat to be activated.

        System.out.println("Welcome to digital rock, paper, scissors!");
        //Welcomes user to the program.

        while (true) {

            Scanner userInputScanner = new Scanner(System.in);
            //Creates a scanner, allows user to enter text.

            Random randomNumG = new Random();
            randomNum = randomNumG.nextInt(1, 4);

            String computerInput = switch (randomNum) {
                case 1 -> "ROCK";
                case 2 -> "PAPER";
                case 3 -> "SCISSORS";
                default -> "ERROR. Something went wrong.";
            };
            //Determines computer's pseudorandom move (the default output should never be reached).

            if (computerScore - userScore >= scoreDifferenceForCheats) {
                System.out.println("Psst... hey! Want to cheat? Type \"C\" for a hint or enter any other key to skip the cheat.");
                cheatInput = userInputScanner.next().toUpperCase();
                if (cheatInput.equals("C")) {
                    System.out.println("CHEAT ACTIVATED!");
                    if (computerInput.equals("ROCK")) {
                        System.out.println("You should play PAPER.");
                    } else if (computerInput.equals("PAPER")) {
                        System.out.println("You should play SCISSORS.");
                    } else {
                        System.out.println("You should play ROCK.");
                    }
                } else {
                    System.out.println("Okay, no cheats this round!");
                }
            }
            //Allows user to cheat and see the best move when the scoreDifferenceForCheats is reached.

            System.out.println("Type your response (ROCK, PAPER, or SCISSORS) here or type \"Y\" to quit.");

            userInput = userInputScanner.next().toUpperCase();
            //Takes in user's input.

            while (!userInput.equals("ROCK") && !userInput.equals("PAPER") && !userInput.equals("SCISSORS")) {
                if (userInput.equals("Y")) {
                    if (userScore == 0 && computerScore == 0) {
                        System.out.println("Aw, sad to see you go so soon. Goodbye!");
                    } else if (userScore > computerScore) {
                        System.out.println("Leaving the game as a winner, well done! Goodbye!");
                    } else if (userScore < computerScore) {
                        System.out.println("Better luck next time! Goodbye!");
                    } else {
                        System.out.println("Wow! What a close game!");
                    }
                    System.out.println("FINAL SCORE: " + userScore + " - " + computerScore);
                    System.exit(0);
                    //Allows user to exit the program and prints a message depending on scores.
                } else {
                    System.out.println("Invalid input. Try again.");
                    userInput = userInputScanner.next().toUpperCase();
                }
            }
            //Forces user to type a valid input.

            if ((userInput.equals("ROCK") && computerInput.equals("SCISSORS")) ||
                    (userInput.equals("PAPER") && computerInput.equals("ROCK")) ||
                    (userInput.equals("SCISSORS") && computerInput.equals("PAPER"))) {
                System.out.println(userInput + " versus " + computerInput + "...");
                userScore++;
                System.out.println("USER WINS!");
            } else if (userInput.equals(computerInput)) {
                System.out.println(userInput + " versus " + computerInput + "...");
                System.out.println("TIE!");
            } else {
                System.out.println(userInput + " versus " + computerInput + "...");
                computerScore++;
                System.out.println("COMPUTER WINS!");
            }
            //Determines winner of each round.

            String overallScore = userScore + " - " + computerScore;
            System.out.println("Overall Score: " + overallScore + "\n");
            //Prints out a continuous score and separates each round with a new line.
        }
    }
}