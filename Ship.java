package Final;

public class Ship {
    private String id;
    protected double capacity;
    private Port currentPort;
    private Date arrivalTime;
    private Date departureTime;

    public Ship(double capacity) {
        this.id = "AB-"+((int) (Math.random() * 900) + 100)+"C";
        if(capacity < 0)
        	System.out.print("Invalid capacity");
        else 
        	if(capacity <5000)
        		this.capacity = 5000;
        	else
        		this.capacity = capacity;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return id; // Assuming ship name is the same as its ID
    }

    public double getCapacity() {
        return capacity;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(Port port) {
        this.currentPort = port;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void depart() {
        
        System.out.println("Ship " + id + " has departed from " + currentPort.getName());
        currentPort = null;     //the ship started it trip and it does'nt belong to any port right now
    }

    public void arrive(Port port) {
        
        currentPort = port;      //the ship arrived to the destinated port
        System.out.println("Ship " + id + " has arrived at " + port.getName());
    }
}