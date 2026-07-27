/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.Enterprise;
import Business.People.EmployeeDirectory;
import Business.User.UserDirectory;
import Business.WorkTaskQueue.WorkQueue;

/**
 *
 * @author Ajay Alamuri
 */
public abstract class Organization {
    
    // ATTRIBUTES
    int id;
    String name;
    UserDirectory users;
    EmployeeDirectory employees;
    Enterprise company;
    WorkQueue inTasks;
    WorkQueue outTasks;
    
    // CONSTRUCTORS
    public Organization(String n, int ID, Enterprise enterprise) {
        this.id = ID;
        this.name = n;
        this.company = enterprise;
        this.users = new UserDirectory();
        this.employees = new EmployeeDirectory();
        this.inTasks = new WorkQueue(this);
        this.outTasks = new WorkQueue(this);
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public String GetName() { return this.name; }
    
    public void SetName(String n) { this.name = n; }
    
    public Enterprise GetCompany() { return this.company; }
}
