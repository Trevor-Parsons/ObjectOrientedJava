package proj4;

public class Mammal {
	
	//Mammal double variable declaration 
	private int weight, hunger;
	
	// Mammal String variable declaration 
	private String name, sex;
	
	// Mammal default constructor
	public Mammal()
	{
		weight = (int)(Math.random() * 300 + 1);
		hunger = 0;
		name = "";
		sex = "";
	}
	
	// Mammal variable getter methods
	public int getWeight() {return weight;}
	public int getHunger() {return hunger;}
	public String getName() {return name;}
	public String getSex() {return sex;}
	
	// Mammal variable setter methods
	public void setWeight(int x) {weight = x;}
	public void setHunger(int x) {hunger = x;}
	public void setName(String x) {name = x;}
	public void setSex(String x) {sex = x;}
}
