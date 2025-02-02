package Final;

public interface Management {
    void addEmployee(Employee employee);
    boolean deleteEmployee(String employeeId);
    Employee findEmployee(String employeeId);
    void modifyEmployee(Employee employee);
    void modifySalary(Employee employee, double newSalary);
    void modifyPosition(Employee employee, String newPosition);
    Employee searchEmployee(String employeeId);
}