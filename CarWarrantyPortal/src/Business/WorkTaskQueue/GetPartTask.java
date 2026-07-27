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
    public boolean BackOrder() {
        // TODO
        return false;
    }
}
