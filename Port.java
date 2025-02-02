package Final;

import java.util.*;


public class Port {
    private String name;
    private String location;
    private List<Employee> employees;
    private List<Ship> ships;
    
    
    public Port(String name, String location) {
        this.name = name;
        this.location = location;
        this.employees = new ArrayList<>();
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void addShip(Ship ship) {
        ships.add(ship);
    }
    public void displayShips() {
        if (ships.isEmpty()) {
            System.out.println("No ships available in the port.");
        } else {
            System.out.println("Ships available in the port:");
            for (Ship ship : ships) {
                System.out.println("Ship ID: " + ship.getId());
            }
        }
    }
    public void removeShip(Ship ship) {
        if (ships.contains(ship)) {
            ships.remove(ship);
            
        } else {
            System.out.println("Ship " + ship.getId() + " is not present in the port.");
        }
    }

    public void receiveShip(Ship ship) {
        
        ship.setCurrentPort(this);
        System.out.println("Ship " + ship.getId() + " has been received at " + this.location+", "+this.name);
    }
    public void sendShip(Ship ship) {
        if (ship.getCurrentPort() == this) {
            System.out.println("Ship " + ship.getId() + " is being sent from " + this.getName());
            ship.depart();
        } else {
            System.out.println("Ship " + ship.getId() + " does not belong to " + this.getName());
        }
    }
    
    public Ship findShip(String shipName) {
        for (Ship ship : ships) {
            if (ship.getName().equals(shipName)) {
                return ship;
            }
        }
        return null;
    }

    public void scheduleArrival(Ship ship, Date arrivalTime) {
       
        ship.setArrivalTime(arrivalTime);
        System.out.println("Arrival of Ship " + ship.getId() + " scheduled at " + arrivalTime);
    }

    public void scheduleDeparture(Ship ship, Date departureTime) {
        
        ship.setDepartureTime(departureTime);
        System.out.print("Departure of Ship " + ship.getId() + " scheduled at " + departureTime);
    }

    public void trackCargo(Cargo cargo) {
        
        System.out.print("Tracking cargo: " + cargo.getName()+ " in the port.");
    }
    public void displayAllShips() {
        for (Ship ship : ships) {
            System.out.println(ship.getName());
        }
    }
}