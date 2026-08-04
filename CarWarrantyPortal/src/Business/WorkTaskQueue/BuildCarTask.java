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

  // QA STRUCTURAL ATTRIBUTES
    private String result;     // Tracks inspection choice: "Pass" or "Fail"
    private String qaMessage;  // Form comment storage field for inspector notes

    /**
     * Creates a basic vehicle-build task for existing Production workflows.
     *
     * @param assigner user requesting production
     * @param mk vehicle make
     * @param mdl vehicle model
     */
    public BuildCarTask(User assigner, String mk, String mdl,int vin) {
        super(assigner);
        this.make = mk;
        this.model = mdl;
        this.VIN = vin;
        this.customOrder = null;
        this.result = "Pending";
        this.qaMessage = "";
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
        this.VIN = order.getVehicleVin();
        this.result = "Pending";
        this.qaMessage = "";
    }
    // QA INTERFACE GETTERS & SETTERS
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return qaMessage;
    }

    public void setMessage(String message) {
        this.qaMessage = message;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getVIN() { return VIN; }
    public void setVIN(int VIN) { this.VIN = VIN; }
    public String getTrim() {return customOrder.getTrim();}
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

        return make + " " + model+" "+customOrder.getTrim();
    }
}
