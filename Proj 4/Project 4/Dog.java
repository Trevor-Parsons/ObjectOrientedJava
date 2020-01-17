package proj4;

public class Dog extends Mammal {
	
	// Dog class variables
	private int fun, cleanliness;
	
	// Dog class constructor
	public Dog()
	{
		super.setHunger((int)(Math.random() * 100 + 1));
		fun = (int)(Math.random() * 100 + 1);
		cleanliness = (int)(Math.random() * 100 + 1);
	}
	
	// Dog class getter methods
	public int getFun() {return fun;}
	public int getCleanliness() {return cleanliness;}
	
	// Returns 1 if fun and hunger are > 1, 0 otherwise
	public int getLoyalty() 
	{
		if (fun == 1)
			return 0;
		if (this.getHunger() == 1)
			return 0;
		
		return 1;
	}
	
	// Dog class setter methods
	@Override
	public void setHunger(int x)
	{
		super.setHunger((getHunger() + x));
		
		if (getHunger() < 1)
			super.setHunger(1);
		else if (getHunger() > 100)
			super.setHunger(100);
	}
	
	public void setFun(int x)
	{
		fun += x;
		
		if (fun < 1)
			fun = 1;
		else if (fun > 100)
			fun = 100;
	}
	
	public void setCleanliness(int x) 
	{
		cleanliness += x;
		
		if (cleanliness < 1)
			cleanliness = 1;
		else if (cleanliness > 100)
			cleanliness = 100;
	}
	
	// Returns Dog object variable values in string form
	@Override 
	public String toString()
	{
		return "Dog Name: " + this.getName() + "\nFun: " + fun
				+ "\nHunger: " + this.getHunger() + "\nCleanliness: "
				+ cleanliness + "\n";
	}
}
