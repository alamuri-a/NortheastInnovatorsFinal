/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.CustomerServiceRepresentativeWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class CustomerServiceRepresentative extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public CustomerServiceRepresentative() {
        super(new CustomerServiceRepresentativeWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Customer Service Representative";
    }
    
    @Override
    public void loadWorkArea() {
        // TODO
    }

    public WorkTask getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(WorkTask currentTask) {
        this.currentTask = currentTask;
    }
}
