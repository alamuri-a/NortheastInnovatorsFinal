/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.Part;

/**
 *
 * @author Ajay Alamuri
 */
public class InspectPartTask extends WorkTask {
    
    // ATTRIBUTES
    Part part;
    
    // CONSTRUCTORS
    public InspectPartTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
    }
    
    // METHODS
    /**
     * Deny shipping of part due to defects
     * 
     * @return True if part is not working, False if part is working
     */
    public boolean deny() {
        // TODO
        return false;
    }
}
