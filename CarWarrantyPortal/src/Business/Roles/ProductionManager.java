/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.ProductionManagerWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class ProductionManager extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public ProductionManager() {
        super(new ProductionManagerWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Production Manager";
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
