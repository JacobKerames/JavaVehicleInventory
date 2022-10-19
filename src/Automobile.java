//Jacob Kerames

public class Automobile {
	
	private int id;
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	//Default constructor
	Automobile() {
		
	}
	
	//Parameterized Constructor
	Automobile(int id, String make, String model, String color, int year, int mileage) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
	
	//Getter methods
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public int getYear() {
		return year;
	}
	public int getMileage() {
		return mileage;
	}
	
	//Setter methods
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
