/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.Organization.ProductionOrganization;
import Business.User.User;
import Business.Vehicle.Part;

/**
 *
 * @author Ajay Alamuri
 */
public class GetPartTask extends WorkTask {
    
    // ATTRIBUTES
    Part part;
    int quantity;
    boolean backordered;
    
    // CONSTRUCTORS
    public GetPartTask(User assigner, Part pt, int count) {
        super(assigner);
        this.part = pt;
        this.quantity = count;
        this.backordered = false;
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Get Part";
    }

    public Part getPart() {
        return part;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isBackordered() {
        return backordered;
    }
    
    
    /**
     * Request production to make specified part
     */
    public boolean BackOrder(ProductionOrganization production) {
        try {
            production.getInTasks().createBuildPartTask(this.assigner, this.part);
            this.backordered = true;
        } catch (Exception e) {
            this.backordered = false;
        }
        return this.backordered;
    }
}
