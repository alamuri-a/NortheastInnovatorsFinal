/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import People.EmployeeDirectory;
import User.UserDirectory;
import WorkTaskQueue.WorkQueue;

/**
 *
 * @author Ajay Alamuri
 */
public class Organization {
    
    // ATTRIBUTES
    int id;
    String name;
    UserDirectory users;
    EmployeeDirectory employees;
    WorkQueue inTasks;
    WorkQueue outTasks;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public Organization(String n) {
        this.id = ++instances;
        this.name = n;
        this.users = new UserDirectory();
        this.employees = new EmployeeDirectory();
        this.inTasks = new WorkQueue();
        this.outTasks = new WorkQueue();
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public String GetName() { return this.name; }
    
    public void SetName(String n) { this.name = n; }
}
