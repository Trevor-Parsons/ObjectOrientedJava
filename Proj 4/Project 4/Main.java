package proj4;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Input variables
		int intInput = 0;
		String strInput = " ";
		char userChoice = ' ';
		
		// Game variables
		int numHumans = 0;
		boolean cont = true;
		
		// ArrayList of Human objects for game loop
		ArrayList<Human> HumArray = new ArrayList<Human>();
		Scanner input = new Scanner(System.in);
		
		// Ask user for number of Humans
		System.out.print("Enter the number of humans: ");
		numHumans = input.nextInt();
		
		// Initialize ArrayList of Humans and assign dogs
		for (int i = 0; i < numHumans; i++)
		{
			HumArray.add(new Human()); 
			
			// Get name of human from user
			System.out.print("First Name of human number " + (i + 1) + ": ");
			
			strInput = input.next();
			
			HumArray.get(i).setName(strInput);
			
			// Get number of dogs and their names from user
			System.out.print("How many dogs do they own (1 or 2)?: ");
			
			intInput = input.nextInt();
			
			HumArray.get(i).setNumDogs(intInput);
			HumArray.get(i).letDogsOut(intInput);
			
			for (int j = 0; j < intInput; j++)
			{
				System.out.print("Enter Dog number " + (j + 1) + " name: ");
				
				strInput = input.next();
				
				HumArray.get(i).addDog(j, strInput);
			}
		}
		
		System.out.println("\n\n");
		
		// Game loop
		while (cont == true)
		{
			for (int i = 0; i < numHumans; i++)
			{
				// Execute passTheTime method for all humans and dogs
				for (int j = 0; j < HumArray.get(i).getNumDogs(); j++)
				{
					HumArray.get(i).passTheTime(j);
				}
				
				// Print out all human and dog variable values
				System.out.println(HumArray.get(i).toString());
			}
			
			for (int i = 0; i < numHumans; i++)
			{
				// Access each human and determine what they will do with their dog
				if (cont == false)
					break;
				
				for (int j = 0; j < HumArray.get(i).getNumDogs(); j++)
				{	
					// Get action for each dog a human owns from user
					System.out.println("What should " + HumArray.get(i).getName() 
						              	+ " do with " + HumArray.get(i).getDog(j).getName() + "?");
					
					System.out.println("Enter: \n'w' to walk the dog, \n'b' to bathe the dog"
							+ "\n'f' to feed the dog, \n'a' to buy food for the dog"
							+ "\n'p' to pass the time \n'q' to quit the game"); 
					
					userChoice = input.next().charAt(0);
					
					// If statements for user choice
					if (userChoice == 'w')
					{
						HumArray.get(i).walks(j);
					}
					else if (userChoice == 'b')
					{
						HumArray.get(i).bathes(j);
					}
					else if (userChoice == 'f')
					{
						if (HumArray.get(i).getDogFood() > 1)
							HumArray.get(i).feeds(j);
						else
							System.out.println("They don't have any dog food!");
					}
					else if (userChoice == 'a')
					{
						if (HumArray.get(i).getMoney() >= 10)
							HumArray.get(i).buysFood();
						else
							System.out.println("Not enough money to buy dog food!");
					}
					else if (userChoice == 'p')
					{
						HumArray.get(i).passTheTime(j);
					}
					else if (userChoice == 'q')
					{
						cont = false;
						System.out.println("Thanks for playing!"); 
						break;
					}
					
					// End program if fun or hunger is equal to 1
					if (HumArray.get(i).checkLoyalty(j) == false)
					{
						System.out.println(HumArray.get(i).getDog(j).getName() +
											" is sick of this treatment, he ran away! Game Over");
							
						cont = false;
						break;
					}
				}
			}
		}
		
		input.close();
	}
}
