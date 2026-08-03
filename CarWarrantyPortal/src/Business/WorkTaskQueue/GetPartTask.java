/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.Organization.ProductionOrganization;
import Business.User.User;
import Business.Vehicle.Part;
import Business.Vehicle.CustomVehicleOrder;
/**
 *
 * @author Ajay Alamuri
 * @author Nicholas Woodward
 */
public class GetPartTask extends WorkTask {
    
        // Part and quantity requested from Supplier Warehouse inventory.
    private Part part;
    private int quantity;
    private boolean backordered;

    // Optional dealership order that needs these components.
    private CustomVehicleOrder customOrder;

    /**
     * Creates a standard Warehouse part-retrieval task.
     *
     * @param assigner user requesting parts
     * @param pt requested part
     * @param count requested quantity
     */
    public GetPartTask(User assigner, Part pt, int count) {
        this(assigner, pt, count, null);
    }

    /**
     * Creates a Warehouse part-retrieval task linked to a customer order.
     *
     * @param assigner Sales Representative requesting parts
     * @param pt requested component
     * @param count requested quantity
     * @param order customer order needing the components
     */
    public GetPartTask(
            User assigner,
            Part pt,
            int count,
            CustomVehicleOrder order) {

        super(assigner);

        if (pt == null) {
            throw new IllegalArgumentException("A part is required.");
        }

        if (count <= 0) {
            throw new IllegalArgumentException(
                    "Requested quantity must be greater than zero.");
        }

        this.part = pt;
        this.quantity = count;
        this.backordered = false;
        this.customOrder = order;
    }

    /**
     * Returns the customer order that initiated this part request.
     *
     * @return linked order, or null for general warehouse requests
     */
    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    @Override
    public String toString() {
        if (customOrder != null) {
            return customOrder.getOrderId() + " - Source Components";
        }

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
     * Requests Manufacturer Production to build the required part.
     *
     * @param production manufacturer Production organization
     * @return true when the back-order was successfully created
     */
    public boolean BackOrder(ProductionOrganization production) {
        try {
            production.getInTasks().createBuildPartTask(
                    this.getAssigner(), this.part);
            this.backordered = true;
        } catch (Exception exception) {
            this.backordered = false;
        }

        return this.backordered;
    }
}