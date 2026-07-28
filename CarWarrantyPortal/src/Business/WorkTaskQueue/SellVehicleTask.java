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
public class SellVehicleTask extends WorkTask {
    
    // ATTRIBUTES
    String make;
    String model;
    
    // CONSTRUCTORS
    public SellVehicleTask(User assigner, String mk, String mdl) {
        super(assigner);
        this.make = mk;
        this.model = mdl;
    }
    
    // METHODS
    /**
     * Request production to make specified car
     * 
     * @return True if build is complete, False if still waiting
     */
    public boolean orderBuild() {
        // TODO
        return false;
    }
}
