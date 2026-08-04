package Business.WorkTaskQueue;


import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class BuildCarTask extends WorkTask {

    private String make;
    private String model;
    private int VIN;
    private CustomVehicleOrder customOrder;

    // CHANGED: Use OrderStatus enum instead of raw String "Pending"/"Pass"/"Fail"
    private OrderStatus status;
    private String qaMessage;

    public BuildCarTask(User assigner, String mk, String mdl, int vin) {
        super(assigner);
        this.make = mk;
        this.model = mdl;
        this.VIN = vin;
        this.customOrder = null;
        this.status = OrderStatus.IN_PRODUCTION; // Initial default status
        this.qaMessage = "";
    }

    public BuildCarTask(User assigner, CustomVehicleOrder order) {
        super(assigner);
        if (order == null) {
            throw new IllegalArgumentException("A custom vehicle order is required for production.");
        }
        this.customOrder = order;
        this.make = order.getMake();
        this.model = order.getModel();
        this.VIN = order.getVehicleVin();

        // Grab existing status from order or default to production
        this.status = (order.getStatus() != null) ? order.getStatus() : OrderStatus.IN_PRODUCTION;
        this.qaMessage = "";
    }

    // CHANGED: Updated getters/setters to enforce OrderStatus enum
    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        // Keep the main customer order synchronized
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
        return ""; // Safe fallback if no custom order
    }

    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    @Override
    public String toString() {
        if (customOrder != null) {
            return customOrder.getOrderId() + " - " + customOrder.getVehicleDescription();
        }
        return make + " " + model + " " + getTrim();
    }
}
