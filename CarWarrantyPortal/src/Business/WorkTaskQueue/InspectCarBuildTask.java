/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.Enterprise.DealershipEnterprise;
import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;

/**
 * Custom QA workflow tracker specifically for managing vehicle quality inspections.
 * Modeled directly on the structural signature of BuildCarTask.
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 */
public class InspectCarBuildTask extends WorkTask {
    // Basic vehicle data retained for tracking the asset under inspection.
    private String make;
    private String model;
    private int VIN;
    private String trim;

    // Links the inspection task to the dealership's customer order.
    private CustomVehicleOrder customOrder;
    private DealershipEnterprise destinationDealership;

    // CHANGED: Use OrderStatus enum instead of raw String "Pending"/"Pass"/"Fail"
    private OrderStatus status;
    private String qaMessage; // Form comment storage field for inspector notes


    /**
     * Creates a basic vehicle-inspection task for general Production workflows.
     *
     * @param assigner user requesting the inspection
     * @param mk vehicle make
     * @param mdl vehicle model
     */
    public InspectCarBuildTask(User assigner, String mk, String mdl) {
        super(assigner); // Sets unique ID and completed = false via parent constructor
        this.make = mk;
        this.model = mdl;
        this.customOrder = null;
        this.status = OrderStatus.READY_FOR_PRODUCTION; // Safe default state before QA
        this.qaMessage = "";
    }

    /**
     * Creates an inspection task linked to a validated dealership custom order.
     *
     * @param assigner Representative requesting the quality audit
     * @param order customer vehicle order to inspect
     */
    public InspectCarBuildTask(User assigner, CustomVehicleOrder order) {
        super(assigner);
        if (order == null) {
            throw new IllegalArgumentException(
                    "A custom vehicle order is required for quality inspection tracking.");
        }
        this.customOrder = order;
        this.make = order.getMake();
        this.model = order.getModel();

        // Grab current order state, or fallback to standard workflow step
        this.status = (order.getStatus() != null) ? order.getStatus() : OrderStatus.READY_FOR_PRODUCTION;
        this.qaMessage = "";
    }

    // CHANGED: Getters and setters refactored to support OrderStatus
    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        // Automatically sync status change back up to the master custom order tracking block
        if (this.customOrder != null) {
            this.customOrder.setStatus(status);
        }
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

    public String getTrim() {
        if (customOrder != null) {
            return customOrder.getTrim();
        }
        return this.trim != null ? this.trim : ""; // Protects against null pointers
    }

    /**
     * Returns the custom order associated with this vehicle inspection.
     *
     * @return customer order, or null for general generic tasks
     */
    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }
// Inside InspectCarBuildTask.java
            public DealershipEnterprise getDestinationDealership() {
            return this.destinationDealership; // Ensure this attribute is initialized when task is built
                }

    /**
     * Returns a readable QA queue label.
     *
     * @return linked order ID and vehicle, or the basic vehicle description
     */
    @Override
    public String toString() {
        if (customOrder != null) {
            return "QA-" + customOrder.getOrderId() + " - " + customOrder.getVehicleDescription();
        }
        return "QA - " + make + " " + model;
    }
}
