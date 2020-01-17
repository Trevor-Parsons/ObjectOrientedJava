// Class containing the main function to test the LinearEquation class
// By: Trevor Parsons 

package proj2;

import java.util.*;

public class TestClass {
	
	public static void main(String[] args) {
		// Variable declaration
		double a, b, c, d, e, f;
		Scanner input = new Scanner(System.in);
		
		// Program introduction
		System.out.println("Welome to the linear equation solver!");
		System.out.println("This program can solve an equation for x and y where:\n");
		System.out.println("(a * x) + (b * y) = e\n(a * f) - (e * c) = f\n");
		
		// Get user input for variables a-f
		System.out.println("Please enter a value for a");
		a = input.nextInt();
		System.out.println("Please enter a value for b");
		b = input.nextInt();
		System.out.println("Please enter a value for c");
		c = input.nextInt();
		System.out.println("Please enter a value for d");
		d = input.nextInt();
		System.out.println("Please enter a value for e");
		e = input.nextInt();
		System.out.println("Please enter a value for f");
		f = input.nextInt();
		
		// Create LinearEquation object with user provide values
		LinearEquation userEquation = new LinearEquation(a, b, c, d, e, f);
		
		// Determine if user values generate a solution to the linear equation
		if (userEquation.isSolvable() == false)
		{
			// If the equation has no solutions, inform the user
			System.out.println("That equation has no solutions.");
		}
		else 
		{
			// If the equation has solutions, show them to the user
			System.out.println("That equation has the following solutions:");
			System.out.println("x = " + userEquation.getX());
			System.out.println("y = " + userEquation.getY());
		}
		
		// Close the scanner input object 
		input.close();
	}
		
}
