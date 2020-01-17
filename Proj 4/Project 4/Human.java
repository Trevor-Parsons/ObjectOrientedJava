package proj4;

import java.util.*;

public class Human extends Mammal {
	
	// Human class variables
	private int money, dogFood, numDogs;
	
	// ArrayList for Dogs owned by Human
	private ArrayList<Dog> dogs = new ArrayList<Dog>();

	// Human default constructor
	public Human() 
	{
		double money = (int)(Math.random() * 100 + 1);
		double dogFood= (int)(Math.random() * 10 + 1);
		numDogs = 0;
	}
	
	// Human variable getter methods
	public int getMoney() {return money;}
	public int getDogFood() {return dogFood;}
	public int getNumDogs() {return numDogs;}
	public Dog getDog(int x) {return dogs.get(x);} 
	
	// Human variable setter methods
	public void setMoney(int x) {money = x;}
	public void setDogFood(int x) {dogFood = x;}
	public void setNumDogs(int x) {numDogs = x;}
	
	
	// Dog Array List modifiers
	public void letDogsOut(int x)
	{
		for (int i = 0; i < x; i++)
		{
			dogs.add(new Dog());
			
		}
	}
	
	public void addDog(int x, String y)
	{
		dogs.get(x).setName(y);
	}
	
	
	// Human action methods 
	public void walks(int x) 
	{
		dogs.get(x).setFun(50);
		dogs.get(x).setCleanliness((-10));
		dogs.get(x).setHunger((-10));
		
	}
	
	public void feeds(int x) 
	{
		dogs.get(x).setFun(10);
		dogs.get(x).setCleanliness(-10);
		dogs.get(x).setHunger(50);
		
		dogFood -= 1;
	}
	
	public void bathes(int x) 
	{
		dogs.get(x).setFun(-10);
		dogs.get(x).setCleanliness(100);
	}
	
	public void passTheTime(int x) 
	{
		dogs.get(x).setFun(-1);
		
		money += 10;
	}
	
	public void buysFood() 
	{
		dogFood += 5;
		money -= 10;
	}
	
	// Determines if dog's hunger is 1 or fun is 1
	public boolean checkLoyalty(int x)
	{
		if (dogs.get(x).getLoyalty() == 0)
			return false;
		
		return true;
	}
	
	// To string method to print Human variable values
	// and the variable values of the dog(s) they own
	@Override
	public String toString() 
	{
		if (numDogs == 1)
			return "Human Name: " + getName() + "\nMoney: $" + getMoney() 
					+ "\nDog Food: " + getDogFood() + "\n\n" + dogs.get(0).toString();
		else
			return "Human Name: " + getName() + "\nMoney: $" + getMoney() 
					+ "\nDog Food: " + getDogFood() + "\n\n"+ dogs.get(0).toString() + "\n" 
					+ dogs.get(1).toString();
	}
}
