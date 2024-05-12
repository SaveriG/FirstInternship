package internshipProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
	    public static void main(String[] args) {
	        GuessTheNumber methodChange = new GuessTheNumber();
	        methodChange.menu(scoreBoard);
	    }
	    public void menu(ArrayList<Integer> scoreBoard) {
	        GuessTheNumber  guessNum = new GuessTheNumber();
	   
	        Scanner input = new Scanner(System.in);
	        System.out.println("--------------------");
	        System.out.println("Welcome to  the Number game");
	        System.out.println("1) Play the Game");
	        System.out.println("2) Display The Score ");
	        System.out.println("3) Exit the game");
	        System.out.println("--------------------");
	        
	            System.out.print("....Please Enter The One Option from above Actions... ");
	            int optionForPlay = input.nextInt();
	            
	            while(true) {
	            switch (optionForPlay) {
	                case 1:
	                    System.out.print("\n"+" Please Enter a number Between 1 to 100 ");
	                    int numberRange = input.nextInt();
	                    int sysGenNumber = guessNum.systemNumber(numberRange);
	                    guessNum.guessNumber(sysGenNumber);
	                    break;
	                case 2:
	                    guessNum.displayScoreBoard();
	                    break;
	                case 3:
	                    System.out.println("\n"+"Thanks for playing the game!");
	                    System.exit(1);
	                    break;
	                default:
	                    System.err.println("Invalid number entry.Could you please Try again later");
	            }
	       
	        }
	    }
	    
	    public int systemNumber(int rangeOfNumbers) {
	        Random random = new Random();
	        int numberRange = random.nextInt(rangeOfNumbers);
	        return numberRange;
	    }
	    public void guessNumber(int systemNumber) {
	        Scanner input = new Scanner(System.in);
	        int userGuess;
	        int guess = 0;
	        do {
	            System.out.print("Enter your guess number: ");
	            userGuess = input.nextInt();
	            guess++;
	            if (userGuess > systemNumber) {
	                System.out.println("Lower");
	            } else if (userGuess < systemNumber) {
	                System.out.println("Higher");
	            }
	        } while (systemNumber != userGuess);
	        System.out.println(" ");
	        if (guess == 1) {
	            System.out.println("Congratulations ! You Guess The Number in " + guess + " try!");
	        } else {
	            System.out.println("Good Play !! You Guess The Number in " + guess + " tries!");
	        }
	        scoreBoard.add(guess);
	        System.out.println(" ");

	        menu(scoreBoard);
	    }
	    public void displayScoreBoard() {
	        System.out.println("--------------------");
	        System.out.println("Score Board");
	        System.out.println("--------------------");
	        System.out.println("Well Play ********* The Number Of tries are " +"\n");
	        Collections.sort(scoreBoard);
	        for (Integer scores : scoreBoard) {
	            System.out.println("Finished !!! Guess The Number in " + scores + " tries");
	        }
	        System.out.println(" ");
	        menu(scoreBoard);
	    }

}
