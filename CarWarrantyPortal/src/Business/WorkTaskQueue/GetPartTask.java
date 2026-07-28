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
public class GetPartTask extends WorkTask {
    
    // ATTRIBUTES
    Part part;
    
    // CONSTRUCTORS
    public GetPartTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
    }
    
    // METHODS
    /**
     * Request production to make specified part
     * 
     * @param part Part needing to be back ordered
     * 
     * @return True if back order is complete, False if still waiting
     */
    public boolean BackOrder(Part part) {
        // TODO
        return false;
    }
}
