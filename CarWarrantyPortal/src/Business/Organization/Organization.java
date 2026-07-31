/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.Enterprise;
import Business.People.EmployeeDirectory;
import Business.Roles.Role;
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
    Role role;
    private int organizationID;
    private static int counter=0;
    
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


    public enum Type{
        Admin("Admin Organization"),
        Production("Production Organization"),
        QA("Quality Assurance Organization"),
        Sales("Sales Organization"),
        ServiceCenter("Service Center Organization"),
        Warehousing("Warehousing Organization"),
        Logistics("Logistics/Shipping Organization");;
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
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
    
    public Enterprise getCompany() {
        return this.company;
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

    public WorkQueue getInTasks() {
        return inTasks;
    }

    public void setInTasks(WorkQueue inTasks) {
        this.inTasks = inTasks;
    }

    public WorkQueue getOutTasks() {
        return outTasks;
    }

    public void setOutTasks(WorkQueue outTasks) {
        this.outTasks = outTasks;
    }
   
}
