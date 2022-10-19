//Jacob Kerames

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		//Initialize
		int input = 0;
		FileOutputStream fileStream = null;
		PrintWriter outFS = null;
		ArrayList<Automobile> vehicles = new ArrayList<Automobile>();
		
		//Create Scanner
		Scanner sc = new Scanner(System.in);

		try {
			//Call vehicle class with parameterized constructor
			Automobile classCall = new Automobile(0, "Ford", "Bronco", "Red", 2003, 103543);
			
			//Add vehicle to ArrayList
			vehicles.add(classCall);
			
			System.out.println("\nVehicle Inventory Program");
			do {
				//Menu
				System.out.println("\nWould you like to:\n1. Add a vehicle\n2. List vehicle information\n3. Remove a vehicle\n4. Update a vehicle\n5. Exit the inventory");
				
				input = sc.nextInt();
				if(input == 1) {
					AddVehicle(vehicles, sc);
				}
				else if(input == 2) {
					ListVehicles(vehicles);
				}
				else if(input == 3) {
					RemoveVehicle(vehicles, sc);
				}
				else if(input == 4) {
					UpdateVehicle(vehicles, sc);
				}
				else if(input == 5) {
					System.out.println("Exiting the inventory. Would you like to print the inventory to a file? (Y/N): ");
					char confirm = sc.next().charAt(0);
					if(confirm == 'Y') {
						//Create file
						fileStream = new FileOutputStream("/Users/jacobkerames/Desktop/Programming I/Eclipse/Vehicle Class Methods/vehicleinventory.txt");
						outFS = new PrintWriter(fileStream);
						
						//Set up file for inventory data
						outFS.println("Vehicle Inventory\n");
						outFS.println("ID  Make  Model  Color  Year  Mileage");
						
						//Iterate ArrayList and print values to file
						for(int i = 0; i < vehicles.size(); i++) {
							Automobile vehicle = vehicles.get(i);
							outFS.printf("%d   %s   %s   %s   %d   %d \n", vehicles.indexOf(vehicle), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage());
						}
						
						//Close PrintWriter
						outFS.close();
						
						//Return message
						System.out.println("Inventory printed to file.");
					}
					else if(confirm == 'N') {
						//Return message
						System.out.println("Inventory not printed to file.");
					}
				}
			} while(input != 5);
		}
		catch(Exception e) {
			//Return message
			System.out.println(e.getMessage());
			System.out.println("Failure\n");
		}
	}
	
	//Add vehicle
	public static void AddVehicle(ArrayList<Automobile> vehicles, Scanner sc) {
		try {
			//Prompt user for and store vehicle data
			System.out.println("Enter the vehicle make: ");
			sc.nextLine();
			String make = sc.nextLine();
			System.out.println("Enter the vehicle model: ");
			String model = sc.nextLine();
			System.out.println("Enter the vehicle color: ");
			String color = sc.nextLine();
			System.out.println("Enter the vehicle year: ");
			int year = sc.nextInt();
			System.out.println("Enter the vehicle mileage: ");
			int mileage = sc.nextInt();
			int id = (vehicles.size() + 1);
			
			//Create vehicle and add to ArrayList
			Automobile vehicle = new Automobile(id, make, model, color, year, mileage);
			vehicles.add(vehicle);
			
			//Return message
			System.out.printf("\n %s %d %s %s with %d miles has been added.\n", vehicle.getColor(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getMileage());
		}
		catch(Exception e) {
			//Return message
			System.out.println(e.getMessage());
			System.out.println("Unable to add vehicle.");
		}
	}
	
	//List vehicles
	public static void ListVehicles(ArrayList<Automobile> vehicles) {
		try {
			System.out.println("\nVehicle Inventory:");
			System.out.println("ID  Make  Model  Color  Year  Mileage");
			
			//Loop to iterate the ArrayList and list vehicles
			for(int i = 0; i < vehicles.size(); i++) {
				Automobile vehicle = vehicles.get(i);
				System.out.printf("%d   %s   %s   %s   %d   %d \n", vehicles.indexOf(vehicle), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear(), vehicle.getMileage());
			}
		}
		catch(Exception e) {
			//Return message
			System.out.println(e.getMessage());
			System.out.println("Unable to list vehicles.");
		}
	}
	
	//Remove vehicle
	public static void RemoveVehicle(ArrayList<Automobile> vehicles, Scanner sc) {
		try {
			//Prompt user for vehicle ID and store
			System.out.println("Enter the ID of the vehicle you wish to remove: ");
			int toRemove = sc.nextInt();
			
			//Remove vehicle from ArrayList
			vehicles.remove(toRemove);
			
			//Return message
			System.out.println("Vehicle removed.");
		}
		catch(Exception e) {
			//Return message
			System.out.println(e.getMessage());
			System.out.println("Unable to remove vehicle.");
		}
	}
	
	//Update Vehicle
	public static void UpdateVehicle(ArrayList<Automobile> vehicles, Scanner sc) {
		try {
			//Get index of vehicle and store
			System.out.println("Enter the ID of the vehicle you wish to update: ");
			int toUpdate = sc.nextInt();
			
			//Get vehicle at index and print it
			Automobile vehicle = vehicles.get(toUpdate);
			System.out.printf("\n %s %d %s %s with %d miles\n", vehicle.getColor(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getMileage());
			
			//Take updated values and assign them
			System.out.println("\nEnter the updated vehicle make: ");
			sc.nextLine();
			vehicle.setMake(sc.nextLine());
			System.out.println("Enter the updated vehicle model: ");
			vehicle.setModel(sc.nextLine());
			System.out.println("Enter the updated vehicle color: ");
			vehicle.setColor(sc.nextLine());
			System.out.println("Enter the updated vehicle year: ");
			vehicle.setYear(sc.nextInt());
			System.out.println("Enter the updated vehicle mileage: ");
			vehicle.setMileage(sc.nextInt());
			
			//Print information
			System.out.printf("\n %s %d %s %s with %d miles has been updated.\n", vehicle.getColor(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getMileage());
		}
		catch(Exception e) {
			//Return message
			System.out.println(e.getMessage());
			System.out.println("Unable to update vehicle.");
		}
	}
}




