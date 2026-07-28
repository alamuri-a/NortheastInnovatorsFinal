/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.Enterprise;
import Business.People.EmployeeDirectory;
import Business.User.UserDirectory;

/**
 *
 * @author Ajay Alamuri
 */
public class AdminOrganization {
    
    // ATTRIBUTES
    int id = 0;
    String name;
    UserDirectory users;
    EmployeeDirectory employees;
    Enterprise company;
    
    // CONSTRUCTORS
    public AdminOrganization(Enterprise ent) {
        this.company = ent;
        this.name = ent.getName() + "Admin";
        this.users = new UserDirectory();
        this.employees = new EmployeeDirectory();
    }
    
    // METHODS
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String n) {
        this.name = n;
    }

    public UserDirectory getUsers() {
        return users;
    }

    public void setUsers(UserDirectory users) {
        this.users = users;
    }

    public EmployeeDirectory getEmployees() {
        return employees;
    }

    public void setEmployees(EmployeeDirectory employees) {
        this.employees = employees;
    }

    public Enterprise getCompany() {
        return company;
    }

    public void setCompany(Enterprise company) {
        this.company = company;
    }
    
}
