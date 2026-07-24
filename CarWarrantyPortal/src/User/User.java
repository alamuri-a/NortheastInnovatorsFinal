/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import People.Employee;
import Roles.Role;

/**
 *
 * @author Ajay Alamuri
 */
public class User {
    
    // ATTRIBUTES
    int id;
    Employee employee;
    String username;
    String password;
    Role role;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public User(Employee emp, String usrnm, String pswd, Role rol) {
        this.id = ++instances;
        this.employee = emp;
        this.username = usrnm;
        this.password = pswd;
        this.role = rol;
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public Employee GetEmployee() { return this.employee; }
    
    public String GetUsername() { return this.username; }
    
    public void SetUsername(String n) { this.username = n; }
    
    public String GetPassword() { return this.password; }
    
    public void SetPassword(String p) { this.password = p; }
    
    public boolean Authenticate(String usernameAttempt, String passwordAttempt) {
        return (username.equals(usernameAttempt) && password.equals(passwordAttempt));
    }
}
