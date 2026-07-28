/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.People;

import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class EmployeeDirectory {
    
    // ATTRIBUTES
    ArrayList<Employee> employees;
    
    // CONSTRUCTORS
    public EmployeeDirectory() {
        this.employees = new ArrayList();
    }
    
    // METHODS
    public Employee findEmployee(int eID) {
        for (Employee emp : employees) {
            if (emp.getID() == eID) return emp;
        }
        return null;
    }
    
    public Employee createEmployee(Person p) {
        Employee newEmployee = new Employee(p);
        this.employees.add(newEmployee);
        return newEmployee;
    }
    
    public void removeEmployee(Employee e) {
        this.employees.remove(e);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    
}
