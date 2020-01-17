// LinearEquation class containing the member variables and methods for LinearEquation objects
// By: Trevor Parsons 

package proj2;

import java.util.*;

public class LinearEquation {
	
	// Private variables for LinearEquation objects
	private double a, b, c, d, e, f;
	
	// Constructor for LinearEquation objects
	public LinearEquation(double g, double h, double i, double j, double k, double l)
	{
		a = g;
		b = h;
		c = i;
		d = j;
		e = k;
		f = l;
	}
	
	// Getter methods for LinearEquation object variables
	public double getA() {return a;}
	public double getB() {return b;}
	public double getC() {return c;}
	public double getD() {return d;}
	public double getE() {return e;}
	public double getF() {return f;}
	
	// Method to determine if object values produce a solution to the linear equation 
	public boolean isSolvable()
	{
		if ((a * d - b * c) == 0)
		{
			return false;
		}
		
		return true; 
	}
	
	// Getter methods for linear equation solutions 
	public double getX() {return ((e * d - b * f) / (a * d - b * c));}
	public double getY() {return ((a * f - e * c) / (a * d - b * c));}
}

