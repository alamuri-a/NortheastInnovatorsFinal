/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.User;

import Business.People.Employee;
import Business.Roles.Role;

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
    public int getID() {
        return this.id;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String n) {
        this.username = n;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String p) {
        this.password = p;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public boolean authenticate(String usernameAttempt, String passwordAttempt) {
        return (username.equals(usernameAttempt) && password.equals(passwordAttempt));
    }
}
