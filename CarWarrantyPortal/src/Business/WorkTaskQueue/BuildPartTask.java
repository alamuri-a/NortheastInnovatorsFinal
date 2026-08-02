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
 * @author Nicholas Woodward
 */
public class BuildPartTask extends WorkTask {
    
    // ATTRIBUTES
    Part part;
    
    // CONSTRUCTORS
    public BuildPartTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
    }
        /**
     * Returns the component being built by Production.
     *
     * @return requested part
     */
    public Part getPart() {
        return part;
    }

    /**
     * Returns a readable Production queue label.
     *
     * @return part-build description
     */
    @Override
    public String toString() {
        return "Build " + part;
    }
}
