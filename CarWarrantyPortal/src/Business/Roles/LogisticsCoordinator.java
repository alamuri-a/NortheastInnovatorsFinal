/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.LogisticsCoordinatorWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class LogisticsCoordinator extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public LogisticsCoordinator() {
        super(new LogisticsCoordinatorWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Logistics Coordinator";
    }
    
    @Override
    public void LoadWorkArea() {
        // TODO
    }
}
