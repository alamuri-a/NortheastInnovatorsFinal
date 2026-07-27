/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.WarehouseClerkWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class WarehouseClerk extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public WarehouseClerk() {
        super(new WarehouseClerkWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Customer Service Representative";
    }
    
    @Override
    public void LoadWorkArea() {
        // TODO
    }
}
