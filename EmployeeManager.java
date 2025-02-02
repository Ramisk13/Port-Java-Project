package Final;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager extends Employee implements Management {
    private List<Employee> employees;

    public EmployeeManager(String name, String position, double salary) {
        super(name, position, salary);
        
        employees = new ArrayList<>();
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        Employee employeeToDelete = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                employeeToDelete = employee;
                break;
            }
        }
        
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            return true;
        }
        return false;
    }
    

    @Override
    public void modifyEmployee(Employee employee) {
        // Find the employee in the list
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            if (emp.getId().equals(employee.getId())) {
                emp.setName(employee.getName());
                emp.setPosition(employee.getPosition());
                emp.setSalary(employee.getSalary());
                System.out.print("Employee modified: " + employee.getName());
                return;
            }
        }
        System.out.print("Employee not found");
    }

    @Override
    public void modifySalary(Employee employee, double newSalary) {
        employee.setSalary(newSalary);
        System.out.print("Salary modified for employee: " + employee.getName());
    }

    @Override
    public void modifyPosition(Employee employee, String newPosition) {
        employee.setPosition(newPosition);
        System.out.print("Position modified for employee: " + employee.getName());
    }

    @Override
    public Employee searchEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                System.out.print("Employee found: " + employee.getName());
                return employee;
            }
        }
        System.out.print("Employee not found");
        return null;
    }
    @Override
    public Employee findEmployee(String employeeId) {
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                return employee;
            }
        }
        return null; // Employee not found
    }
}
