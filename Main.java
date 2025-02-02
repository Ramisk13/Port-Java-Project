package Final;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Main  {
	
	
	
	
	
	public static void saveShipsToCSV(List<Ship> ships) {
        try (FileWriter writer = new FileWriter("ships.csv")) {
            writer.write("Id,Capacity,CurrentPort,ArrivalTime,DepartureTime\n");
            for (Ship ship : ships) {
                writer.write(
                        ship.getId() + "," +
                        ship.getCapacity() + "," +
                        (ship.getCurrentPort() != null ? ship.getCurrentPort().getName() : "") + "," +
                        (ship.getArrivalTime() != null ? ship.getArrivalTime().toString() : "") + "," +
                        (ship.getDepartureTime() != null ? ship.getDepartureTime().toString() : "") + "\n"
                );
            }
            System.out.println("Ships data saved to ships.csv");
        } catch (IOException e) {
            System.out.println("Failed to save ships data: " + e.getMessage());
        }
    }

    public static void saveEmployeesToCSV(List<Employee> employees) {
        try (FileWriter writer = new FileWriter("src/Final/employees.csv")) {
            writer.write("Id,Name,Position\n");
            for (Employee employee : employees) {
                writer.write(
                        employee.getId() + "," +
                        employee.getName() + "," +
                        employee.getPosition() + "\n"
                );
            }
            System.out.println("Employees data saved to employees.csv");
        } catch (IOException e) {
            System.out.println("Failed to save employees data: " + e.getMessage());
        }
    }
	
	
	
	
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0, option = 0;
		String name,position;
		double salary;
		System.out.println("==== Welcome to Port Management System. ====");
		do {
			System.out.print("1-Manager Log in." + "\n2-Employee Log in."+"\n3-Exit."+"\nPlease make a choice : ");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1 : System.out.print("Enter your full name :" );
			 		name = scan.nextLine();
			 		do {
			 		System.out.print("Enter your position :" );
			 		position = scan.nextLine();
			 		}while(!position.equalsIgnoreCase("Manager"));
			 		System.out.print("Enter your Salary :" );
			 		salary = scan.nextInt();
			 		EmployeeManager manager = new EmployeeManager(name,position,salary);
			 		System.out.print("Welcome manager : " + name+"\n");
				
			 		do{
						 
						 
						 System.out.println("1-Add Employee" + "\n2-Delete Employee" + "\n3-Modify Employee" + 
								 "\n4-Display All Employees" + "\n5-Exit" +"\nPlease choose an option : ");
						 option = scan.nextInt();
						 switch(option) {
						 case 1 : scan.nextLine();
						 		  System.out.print("Enter employee name: ");
							       name = scan.nextLine();
							      System.out.print("Enter employee position: ");
							       position = scan.nextLine();
							      System.out.print("Enter employee salary: ");
							       salary = scan.nextDouble();
							       Employee employee = new Employee(name, position, salary);
							       manager.addEmployee(employee);
							       System.out.println("An employee has been added :" + employee );
							       break;
						 case 2 : scan.nextLine(); 
						    	  System.out.print("Enter employee ID to delete: ");
						    	  String deleteId = scan.nextLine();
						    
						    	  boolean isDeleted = manager.deleteEmployee(deleteId);
						    	  if (isDeleted) {
						          System.out.println("Employee with ID " + deleteId + " deleted successfully.");
						    	  } else {
						          System.out.println("Failed to delete employee with ID " + deleteId + ".");
						    	  }
						    	  break;
						 case 3:
							 	scan.nextLine();
							    System.out.println("Enter the ID of the employee to modify: ");
							    String modifyId = scan.nextLine();
							    Employee modifyEmployee = manager.findEmployee(modifyId);
							    
							    if (modifyEmployee != null) {
							        System.out.println("Enter the new name for the employee: ");
							        String newName = scan.nextLine();
							        System.out.println("Enter the new position for the employee: ");
							        String newPosition = scan.nextLine();
							        System.out.println("Enter the new salary for the employee: ");
							        double newSalary = scan.nextDouble();
							        
							        modifyEmployee.setName(newName);
							        modifyEmployee.setPosition(newPosition);
							        modifyEmployee.setSalary(newSalary);
							        
							        System.out.println("Employee modified successfully.");
							    } else {
							        System.out.println("Employee not found.");
							    }
							    break;
							    
						 case 4: List<Employee> allEmployees = manager.getEmployees();
						    
						    if (allEmployees.isEmpty()) {
						        System.out.println("No employees found.");
						    } else {
						        System.out.println("Employees:");
						        for (Employee employee1 : allEmployees) {
						            System.out.println(employee1);
						        }
						    }
						    break;
						 
						 case 5 : break;
						 }
					}while(option != 5);
			
			 		break;
			case 2 : 	Port port = new Port("Lebanon", "Port du Beyrouth");
						do {
						System.out.println("===== Port Management System Menu =====");
			            System.out.println("1- Receive Ship.");
			            System.out.println("2- Send Ship.");
			            System.out.println("3- Schedule Arrival.");
			            System.out.println("4- Schedule Departure.");
			            System.out.println("5- Track Cargo.");
			            System.out.println("6- Display ships in port.");
			            System.out.println("7- Load Passengers onto Ferry");
			            System.out.println("8- Exit.");
			            System.out.print("Enter your choice: ");
			            option = scan.nextInt();
			            
			            switch (option) {
		                case 1 :
			                    // Receive Ship
			                    System.out.println("Enter the ship capacity(in Kg): ");
			                    double shipCapacity = scan.nextDouble();
			                    Ship ship = new Ship(shipCapacity);
			                    port.receiveShip(ship);
			                    port.addShip(ship);
			                    break;
			                    
		                case 2 : // Send Ship
		                			scan.nextLine();
				                  	System.out.print("Enter the ship ID: ");
				                    String shipId = scan.nextLine();
				                    ship = port.findShip(shipId);
				                    if (ship != null) {
				                        port.sendShip(ship);
				                        System.out.println("Ship " + ship.getId() + " sent from the port.");
				                    } else {
				                        System.out.println("Ship " + shipId + " not found in the port.");
				                    }
				                    port.removeShip(ship);
				                    break;
				                   
		                case 3:
		                    // Schedule Arrival
		                    System.out.print("Enter the ship ID: ");
		                    shipId = scan.next();
		                    ship = port.findShip(shipId);
		                    if (ship != null) {
		                        System.out.print("Enter the arrival date (yyyy-MM-dd): ");
		                        String arrivalDateTime = scan.next();
		                        // Parse the arrival date and time and set it on the ship
		                        // ship.setArrivalTime(parsedArrivalDateTime);
		                        System.out.println("Arrival of Ship " + ship.getId() + " scheduled for " + arrivalDateTime);
		                    } else {
		                        System.out.println("Ship " + shipId + " not found in the port.");
		                    }
		                    break;
		                case 4:
		                    // Schedule Departure
		                    System.out.print("Enter the ship ID: ");
		                    shipId = scan.next();
		                    ship = port.findShip(shipId);
		                    if (ship != null) {
		                        System.out.print("Enter the departure date  (yyyy-MM-dd ): ");
		                        String departureDateTime = scan.next();
		                        // Parse the departure date and time and set it on the ship
		                        // ship.setDepartureTime(parsedDepartureDateTime);
		                        System.out.println("Departure of Ship " + ship.getId() + " scheduled for " + departureDateTime);
		                    } else {
		                        System.out.println("Ship " + shipId + " not found in the port.");
		                    }
		                    break;
		                case 5:
		                    // Track Cargo
		                    System.out.print("Enter the cargo name: ");
		                    String cargoName = scan.next();
		                    Cargo cargo = new Cargo(cargoName);
		                    port.trackCargo(cargo);
		                    System.out.print("\n");
		                    break;
		                case 6:
		                    
		                    port.displayShips();
		                    break;
		                case 7:
		                    // Load Ferry Passengers
		                	int maxPassengers;
		                    do{
		                    	System.out.print("Enter the maximum number of passengers allowed on the ferry: ");
		                    	maxPassengers = scan.nextInt();
		                    }while(maxPassengers<70 || maxPassengers > 500);
		                	double ferryCapacity;
		                    do{
		                    	System.out.print("Enter the ferry capacity: ");
		                    	 ferryCapacity = scan.nextDouble();
		                    }while(ferryCapacity<0 || ferryCapacity> maxPassengers );
		                    
		                     
		                    Ferry ferry = new Ferry(ferryCapacity, maxPassengers);
		                    ferry.setCurrentPort(port);
		                    port.sendShip(ferry);
		                    System.out.println("Ferry " + ferry.getId() + " with a capacity of " + ferryCapacity + " and a maximum of " +
		                            maxPassengers + " passengers has departed from " + port.getLocation() + ", " + port.getName());

		                    break;
 
		                case 8:
		                    System.out.println("Exiting...");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
			            }
		}while(option != 8);
		
		

		
	}
		}while(choice != 3);
	}
}

