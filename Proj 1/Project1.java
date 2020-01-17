// Hunter-Ninja-Bear Game
// By: Trevor Parsons

package hw1;

import java.util.*;

public class Project1 {

	public static void main(String[] args) {
		
		// variable declaration 
		boolean playAgain = true;
		int win = 0, loss = 0, tie = 0; 
		int userChoice = 0;
		int computerChoice = 0;
		int previousUserChoice = 0;
		char contChoice;
		Scanner input = new Scanner(System.in);
		
		// Game introduction
		System.out.println("Welcome to Hunter-Bear-Ninja!\n\n");
		System.out.println("Press 1 for Hunter, 2 for Bear, or 3 for Ninja.\n");
		
		// Loop that allows the game to be played continuously 
		while(playAgain == true)
		{
			
			// User choice selection
			System.out.println("Enter your number: ");
			userChoice = input.nextInt();
			
			// Error checking for user input
			while (userChoice < 1 || userChoice > 3)
			{
				System.out.println("You can only pick 1, 2, or 3. Try again:");
				userChoice = input.nextInt();
			}
			
			
			// Very basic computer strategy
			if (previousUserChoice == 0)
			{
				computerChoice = 1 + (int)(Math.random() * ((3 - 1) + 1));
			}
			else if (previousUserChoice == 1)
			{
				computerChoice = 3;
			}
			else if (previousUserChoice == 2)
			{
				computerChoice = 1;
			}
			else if (previousUserChoice == 3)
			{
				computerChoice = 2; 
			}
			
			// Tie combinations 
			if (userChoice == 1 && computerChoice == 1)
			{	
				System.out.println("We both picked Hunter, it's a draw!");
				tie++;
			}
			else if (userChoice == 2  && computerChoice == 2)
			{
				System.out.println("We both picked Bear, it's a draw!");
				tie++;
			}
			else if (userChoice == 3 && computerChoice == 3)
			{
				System.out.println("We both picked Ninja, it's a draw!");
				tie++; 
			}
			// User win combinations 
			else if (userChoice == 1 && computerChoice == 2)
			{
				System.out.println("You picked Hunter and I picked Bear, you win!");
				win++;
			}
			else if (userChoice == 2 && computerChoice == 3)
			{
				System.out.println("You picked Bear and I picked Ninja, you win!");
				win++;
			}
			else if (userChoice == 3 && computerChoice == 1)
			{
				System.out.println("You picked Ninja and I picked Hunter, you win!");
				win++;
			}
			// User loss combinations 
			else if (userChoice == 1 && computerChoice == 3)
			{
				System.out.println("You picked Hunter and I picked Ninja, you lose!");
				loss++;
			}
			else if (userChoice == 2 && computerChoice == 1)
			{
				System.out.println("You picked Bear and I picked Hunter, you lose!");
				loss++; 
				
			}
			else if (userChoice == 3 && computerChoice == 2)
			{
				System.out.println("You picked Ninja and I picked Bear, you lose!");
				loss++;
			}
			
			// Show user win-loss-tie record for current session 
			System.out.println("Your Win-Loss-Tie record is: " + win + "-" + loss + "-" + tie + "\n");
			
			// Ask user if they would like to continue playing 
			System.out.println("Would you like to play again? Enter 'Y' or 'N'");
			
			contChoice = input.next().charAt(0);
			
			previousUserChoice = userChoice; 
			
			if (contChoice == 'N' || contChoice == 'n')
			{
				playAgain = false; 
				
				System.out.println("Thanks for playing!");
			}
		}
	}
}
