/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Ecosystem.Ecosystem;
import Business.Organization.Organization;
import Business.User.User;
import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.LogisticsCoordinatorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class LogisticsCoordinator extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public LogisticsCoordinator() {
        super();
        this.currentTask = null;
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Logistics Coordinator";
    }
    
    @Override
    public JPanel createWorkArea(JPanel workAreaContainer, User user, Organization organization, Ecosystem system) {
        return new LogisticsCoordinatorWorkAreaJPanel(workAreaContainer, user, organization, system);
    }

    public WorkTask getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(WorkTask currentTask) {
        this.currentTask = currentTask;
    }
}
