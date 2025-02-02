package Final;

public class Ferry extends Ship {
    private int maxPassengers;

    public Ferry(double capacity, int maxPassengers) {
        super(capacity);
        this.maxPassengers = maxPassengers;
    }
    
    public void setCapacity(int capacity) {
    	if(capacity > maxPassengers)
    		System.out.print("The capacity exceed the maximum number of passengers allowed.");
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void loadPassengers(int num) {
        System.out.println("Loading " + num + " passengers onto ferry " + getId());
    }
}
