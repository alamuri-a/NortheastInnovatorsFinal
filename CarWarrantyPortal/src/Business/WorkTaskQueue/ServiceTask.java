/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;

/**
 *
 * @author Ajay Alamuri
 */
public class ServiceTask extends WorkTask {
    
    // ATTRIBUTES
    private int VIN;
    
    // CONSTRUCTORS
    public ServiceTask(User assigner, int vin) {
        super(assigner);
        this.VIN = vin;
    }
    
    // METHODS
    /**
     * Request specified part from supplier
     * 
     * @return True if back order is complete, False if still waiting
     */
    public boolean BackOrder() {
        // TODO
        return false;
    }
}
