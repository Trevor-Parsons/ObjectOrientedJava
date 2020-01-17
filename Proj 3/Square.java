package proj3;

import java.util.*;

public class Square {
	// Square class variable declaration 
	private int breezy, stench, pit, person, wumpus, gold;
	
	// Square class constructor
	public Square() {};
	
	// Square class getter methods
	public int getBreezy() {return breezy;}
	public int getStench() {return stench;}
	public int getPit() {return pit;}
	public int getPerson() {return person;}
	public int getWumpus() {return wumpus;}
	public int getGold() {return gold;}
	
	// Square class setter methods
	public void setBreezy(int x) {breezy = x;}
	public void setStench(int x) {stench = x;}
	public void setPit(int x) {pit = x;}
	public void setPerson(int x) {person = x;}
	public void setWumpus(int x) {wumpus = x;}
	public void setGold(int x) {gold = x;}
	
	// Test to determine if all Square variables are 0
	public boolean isEmpty()
	{
		if (breezy == 0 && stench == 0 && pit == 0 && 
			person == 0 && wumpus == 0 && gold == 0)
			return true;
		else
			return false; 
	}
	
}

