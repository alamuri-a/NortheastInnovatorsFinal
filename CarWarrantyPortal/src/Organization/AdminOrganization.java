/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import People.EmployeeDirectory;
import User.UserDirectory;

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
    
    // CONSTRUCTORS
    public AdminOrganization(String n) {
        this.name = n;
        this.users = new UserDirectory();
        this.employees = new EmployeeDirectory();
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public String GetName() { return this.name; }
    
    public void SetName(String n) { this.name = n; }
}
