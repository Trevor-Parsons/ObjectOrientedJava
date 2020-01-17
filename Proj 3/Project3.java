package proj3;

import java.util.*;

public class Project3 {

	public static void main(String[] args) {
		// Variable declaration
		boolean inGame = true;
		Scanner input = new Scanner(System.in);
		char choice = ' ';
		int x = 0,  y = 0;
		
		// Print introduction and instructions for game		
		System.out.println("WELCOME TO WUMPUS WORLD");
		System.out.println("Navigate the Human to find the gold without falling in a pit or being eaten by the Wumpus!");
		System.out.println("To naviagte, enter 'n' for north/up, 's' for south/down, 'e' for east/right, or 'w' for west/left.");
		System.out.println("If you get stuck, enter 'c' to cheat and check the the map, or 'q' to quit.\n\n");
		
		WumpusWorld play = new WumpusWorld();
		
		// Print starting location status for player 
		System.out.println("Your starting location seems to be safe.");
		
		// Enter the loop for game play 
		while (inGame == true)
		{
			// User input for directional movement
			System.out.print("Enter the direction you wish to move: ");
			choice = input.next().charAt(0);
			
			System.out.print("\n");
			
			// Print current game board 
			if (choice == 'C' || choice == 'c')
			{
				System.out.println("Current game board:\nS = Stench\nB = Breezy\n"
						+ "D = Stench and Breezy\nP = Pit\n"
						+ "W = Wumpus\nG = Gold\nH = Current Human Location");
				play.printGameBoard();
			}
			// Move Human location north/up
			else if (choice == 'N' || choice == 'n')
			{
				if (x < 3)
				{
					play.movePerson(x, y, x+1, y);
					x++;
				}
				else
					System.out.println("You can't go any further north!");
			}
			// Move Human location south/down
			else if (choice == 'S' || choice == 's')
			{
				if (x > 0)
				{
					play.movePerson(x, y, x-1, y);
					x--;
				}	
				else
					System.out.println("You can't go any further sourth!");
			}
			// Move Human location east/right
			else if (choice == 'E' || choice == 'e')
			{
				if (y < 3)
				{
					play.movePerson(x, y, x, y+1);
					y++;
				}
				else
					System.out.println("You can't go any further east!");
			}
			// Move Human location west/left
			else if (choice == 'W' || choice == 'w')
			{
				if (y > 0)
				{
					play.movePerson(x, y, x, y-1);
					y--;
				}
				else
					System.out.println("You can go any further west!");
			}
			// Quit the game
			else if (choice == 'Q' || choice == 'q')
			{
				inGame = false;
			}
			else
			// Request proper input 
			{
				System.out.println("Please enter one of the valid options.");
			}
			
			// Print status of current Human location 
			if (inGame == true)
			{
				inGame = play.personSquareStatus(x, y);
			}
			
			if (inGame == false)
			{
				System.out.println("Thanks for playing!");
			}
			
		}
		
	}
	
}
