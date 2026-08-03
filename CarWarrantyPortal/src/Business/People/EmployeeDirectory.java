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
    private ArrayList<Employee> employees;
    
    // CONSTRUCTORS
    public EmployeeDirectory() {
        this.employees = new ArrayList();
    }
    
    // METHODS
    /**
    * Gets employee with matching ID or returns NULL if no employee found with matching ID
    * 
    * @param eID the employee ID
    * 
    * @return {@link Employee} or NULL
    */
    public Employee findEmployee(int eID) {
        for (Employee emp : employees) {
            if (emp.getID() == eID) return emp;
        }
        return null;
    }
    
    /**
    * Create a new Employee, add to internal list of employees, then return employee for modification
    * 
    * @param p Person reference Employee object is created from
    * 
    * @return {@link Employee} the new Employee object created
    */
    public Employee createEmployee(Person p) {
        Employee newEmployee = new Employee(p);
        this.employees.add(newEmployee);
        return newEmployee;
    }
    
    /**
    * Remove specified employee from list of employees
    * 
    * @param e reference to the employee to be deleted
    */
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
