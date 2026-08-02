/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;
/**
 *
 * @author Ajay Alamuri
 * @author Nicholas Woodward
 */
public class BuildCarTask extends WorkTask {

    // Basic vehicle data retained for existing Production work-queue behavior.
    private String make;
    private String model;
    private int VIN;

    // Links a production task to the dealership's customer order.
    private CustomVehicleOrder customOrder;

    /**
     * Creates a basic vehicle-build task for existing Production workflows.
     *
     * @param assigner user requesting production
     * @param mk vehicle make
     * @param mdl vehicle model
     */
    public BuildCarTask(User assigner, String mk, String mdl) {
        super(assigner);
        this.make = mk;
        this.model = mdl;
        this.customOrder = null;
    }

    /**
     * Creates a production task linked to a validated dealership custom order.
     *
     * @param assigner Sales Representative requesting production
     * @param order customer vehicle order to build
     */
    public BuildCarTask(User assigner, CustomVehicleOrder order) {
        super(assigner);

        if (order == null) {
            throw new IllegalArgumentException(
                    "A custom vehicle order is required for production.");
        }

        this.customOrder = order;
        this.make = order.getMake();
        this.model = order.getModel();
    }

    /**
     * Returns the custom order associated with this vehicle build.
     *
     * @return customer order, or null for older general build tasks
     */
    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    /**
     * Returns a readable Production queue label.
     *
     * @return linked order ID and vehicle, or the basic vehicle description
     */
    @Override
    public String toString() {
        if (customOrder != null) {
            return customOrder.getOrderId() + " - "
                    + customOrder.getVehicleDescription();
        }

        return make + " " + model;
    }
}
