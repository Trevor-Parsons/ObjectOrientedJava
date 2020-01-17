package proj3;

import java.util.*;

public class WumpusWorld {
	// WumpusWorld class variable declaration
	private Square[][] gameBoard = new Square[4][4];
	
	// WumpusWorld constructor
	public WumpusWorld()
	{	
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				gameBoard[i][j] = new Square();
			}
		}
		
		int count = 0;
		
		// Assign the player to the starting square
		gameBoard[0][0].setPerson(1);
		
		// Assign a pit to three random squares
		while (count < 3)
		{
			int x = (int)(Math.random() * 4);
			int y = (int)(Math.random() * 4);
			
			if (gameBoard[x][y].getPit() != 1 && x != 0 && y != 0)
			{
				gameBoard[x][y].setPit(1);
				
				count++;
			}
		}
		
		count = 0;
		
		// Assign the Wumpus to a square
		while (count < 1)
		{
			int x = (int)(Math.random() * 4);
			int y = (int)(Math.random() * 4);
			
			if (gameBoard[x][y].getPit() != 1 && x != 0 && y != 0)
			{
				gameBoard[x][y].setWumpus(1);
				 
				count++;
			}
			
		}
		
		count = 0;
		
		// Assign the gold to a square
		while (count < 1)
		{
			int x = (int)(Math.random() * 4);
			int y = (int)(Math.random() * 4);
			
			if (gameBoard[x][y].getPit() != 1 && 
				gameBoard[x][y].getWumpus() != 1 &&
				x != 0 && y != 0)
			{
				gameBoard[x][y].setGold(1);
				count++;
			}
		}
		
		
		// Assign breeze to the north, south, east and west of squares with pits
		for (int x = 3; x >= 0; x--)
		{
			for (int y = 3; y >= 0; y--)
			{
				if (gameBoard[x][y].getPit() == 1)
				{	
					// Set breezy to the north square, if possible
					if (x != 3 && gameBoard[x+1][y].getPit() != 1 
							   && gameBoard[x+1][y].getWumpus() != 1
							   && gameBoard[x+1][y].getGold() != 1)
					{
						gameBoard[x+1][y].setBreezy(1);
					}
					
					// Set breezy to the south square, if possible
					if (x != 0 && gameBoard[x-1][y].getPit() != 1 
							   && gameBoard[x-1][y].getWumpus() != 1
							   && gameBoard[x-1][y].getGold() != 1)
					{
						gameBoard[x-1][y].setBreezy(1);
					}
					
					// Set breezy to the east square, if possible
					if (y != 3 && gameBoard[x][y+1].getPit() != 1 
							   && gameBoard[x][y+1].getWumpus() != 1
							   && gameBoard[x][y+1].getGold() != 1)
					{
						gameBoard[x][y+1].setBreezy(1);
					}
					
					// Set breezy to the west square, if possible
					if (y != 0  && gameBoard[x][y-1].getPit() != 1 
							    && gameBoard[x][y-1].getWumpus() != 1
								&& gameBoard[x][y-1].getGold() != 1)
					{
						gameBoard[x][y-1].setBreezy(1);
					}
				}
			}
		}
		
		// Assign stench to the north, south, east, and west squares of the Wumpus, if possible
		for (int x = 3; x >= 0; x--)
		{
			for (int y = 3; y >= 0; y--)
			{
				if (gameBoard[x][y].getWumpus() == 1)
				{	
					// Set Stench to the north square, if possible
					if (x != 3 && gameBoard[x+1][y].getPit() != 1
							   && gameBoard[x+1][y].getGold() != 1)
					{
						gameBoard[x+1][y].setStench(1);
					}
					
					// Set stench to the south square, if possible
					if (x != 0 && gameBoard[x-1][y].getPit() != 1
							   && gameBoard[x-1][y].getGold() != 1)
					{
						gameBoard[x-1][y].setStench(1);
					}
					
					// Set stench to the east square, if possible
					if (y != 3 && gameBoard[x][y+1].getPit() != 1
							   && gameBoard[x][y+1].getGold() != 1)
					{
						gameBoard[x][y+1].setStench(1);
					}
					
					// Set stench to the west square, if possible
					if (y != 0  && gameBoard[x][y-1].getPit() != 1
							    && gameBoard[x][y-1].getGold() != 1)
					{
						gameBoard[x][y-1].setStench(1);
					}	
				}
			}
		}
	}
	
	// Method to print the state of the board
	public void printGameBoard()
	{
		System.out.println("-----------------");
		
		for (int i = 3; i >= 0; i--)
		{
			System.out.print("| ");
			
			for (int j = 0; j <= 3; j++)
			{
				if (gameBoard[i][j].isEmpty() == true)
				{
					System.out.print("-");
				}
				else
				{
					if (gameBoard[i][j].getBreezy() == 1 &&
						gameBoard[i][j].getStench() == 1)
					{
						System.out.print("D");
					}
					else if (gameBoard[i][j].getBreezy() == 1)
					{
						System.out.print("B");
					}
					else if (gameBoard[i][j].getStench() == 1)
					{
						System.out.print("S");
					}
					
					if (gameBoard[i][j].getPit() == 1)
					{
						System.out.print("P");
					}
					
					if (gameBoard[i][j].getPerson() == 1)
					{
						System.out.print("H");
					}
					
				    if (gameBoard[i][j].getWumpus() == 1)
					{
						System.out.print("W");
					}
				    
					if (gameBoard[i][j].getGold() == 1)
					{
						System.out.print("G");
					}
				}
				
				System.out.print(" | ");
			}
			
			System.out.print("\n-----------------\n");
		}
	}
	
	// Method to inform the player of the status of their current position 
	public boolean personSquareStatus(int x, int y)
	{
		if (gameBoard[x][y].getWumpus() == 1)
		{
			System.out.println("Eaten by the Wumpus, you lose!");
			return false;
		}
		else if (gameBoard[x][y].getGold() == 1)
		{
			System.out.println("You found the gold, you win!");
			return false;
		}
		else if (gameBoard[x][y].getPit() == 1)
		{
			System.out.println("You fell in a pit and died, you lose!");	
			return false;
		}
		else if (gameBoard[x][y].getStench() == 1 && gameBoard[x][y].getBreezy() == 1)
		{
			System.out.println("A cool breeze is carrying a foul stench.");
			return true;
		}
		else if (gameBoard[x][y].getBreezy() == 1)
		{
			System.out.println("A cool breeze is blowing, watch your step!"); 
			return true;
		}
		else if (gameBoard[x][y].getStench() == 1)
		{
			System.out.println("Something smells foul nearby.");
			return true;
		}
		else if (gameBoard[x][y].getStench() == 0 && gameBoard[x][y].getBreezy() == 0)
		{
			System.out.println("Your location seems safe right now.");
			return true;
		}
		else
		{
			System.out.println("Unknown loaction");
			return true;
		}
		
	}
	
	// Method to change the Square location of the Person  
	public void movePerson(int x, int y, int x2, int y2)
	{
		gameBoard[x][y].setPerson(0);
		gameBoard[x2][y2].setPerson(1);
	}
}
