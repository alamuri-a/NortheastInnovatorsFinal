/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.ServiceTechnicianWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class ServiceTechnician extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public ServiceTechnician() {
        super(new ServiceTechnicianWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Service Technician";
    }
    
    @Override
    public void LoadWorkArea() {
        // TODO
    }
}
