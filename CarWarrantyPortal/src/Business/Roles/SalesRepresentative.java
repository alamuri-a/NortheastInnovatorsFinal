/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.SalesRepresentativeWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class SalesRepresentative extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public SalesRepresentative() {
        super(new SalesRepresentativeWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Sales Representative";
    }
    
    @Override
    public void LoadWorkArea() {
        // TODO
    }
}
