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
    private int id;
    private Employee employee;
    private String username;
    private String password;
    private Role role;
    private int tasksCreated;
    private static int instances = 0;
    
    // CONSTRUCTORS
    public User(Employee emp, String usrnm, String pswd, Role rol) {
        this.id = ++instances;
        this.employee = emp;
        this.username = usrnm;
        this.password = pswd;
        this.role = rol;
        this.tasksCreated = 0;
    }
    
    // METHODS
    @Override
    public String toString() {
        return this.employee.getPerson().getName();
    }
    
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
    
    public int getTasksCreated() {
        return this.tasksCreated;
    }
    
    public void incrementTasksCreated() {
        this.tasksCreated++;
    }
    
    /**
    * Checks the provided username and password against stored credential and returns whether matching or not
    * 
    * @param usernameAttempt String with username to check
    * @param passwordAttempt String with password to check
    * 
    * @return True if username and password are correct, False otherwise
    */
    public boolean authenticate(String usernameAttempt, String passwordAttempt) {
        return (username.equals(usernameAttempt) && password.equals(passwordAttempt));
    }
}
