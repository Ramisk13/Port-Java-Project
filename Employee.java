package Final;
public class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.id = position.substring(0,3).toUpperCase()+"-"+ name.toLowerCase().substring(name.length() -3)+"@"+
				(int) (Math.random()*1000+8999);
        
        	this.name = name;

        	this.position = position;
        if (salary < 0 || salary > 6000)
        	this.salary = 1000;
        else
        	this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        	this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        
        	this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
    	if (salary < 0 || salary > 6000)
        	this.salary = 1000;
        else
        	this.salary = salary;
    }
    
    
    public String toString() {
    	return "Name : "+this.name+"\nID : "+this.id+"\nPosition : "+this.position+"\nSalary : "+this.salary;
    }
}