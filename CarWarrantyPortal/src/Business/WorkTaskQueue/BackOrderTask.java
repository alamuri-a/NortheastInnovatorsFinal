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
public class BackOrderTask extends WorkTask {
    
    // ATTRIBUTES
    private Part part;
    
    // CONSTRUCTORS
    public BackOrderTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
    }
}
