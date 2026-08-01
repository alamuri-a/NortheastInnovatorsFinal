package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;

/**
 * Represents the sales work request for one vehicle order.
 * The task controls the order lifecycle from Draft through Delivered.
 *
 * @author nicholaswoodward
 */
public class SellVehicleTask extends WorkTask {

    // Basic vehicle data retained for compatibility with existing work-queue code.
    private String make;
    private String model;

    // Detailed customer order used by the custom-order workflow.
    private CustomVehicleOrder customOrder;

    // Current lifecycle state for this sales task.
    private OrderStatus status;

    /**
     * Creates a basic sales task used by existing work-queue functionality.
     * A task created this way does not yet contain full customer-order data.
     *
     * @param assigner user creating the sales task
     * @param mk vehicle make
     * @param mdl vehicle model
     */
    public SellVehicleTask(User assigner, String mk, String mdl) {
        super(assigner);
        this.make = mk;
        this.model = mdl;
        this.customOrder = null;
        this.status = OrderStatus.DRAFT;
    }

    /**
     * Creates a complete custom vehicle sales task.
     *
     * @param assigner user creating the order
     * @param customOrder validated customer and vehicle-order data
     */
    public SellVehicleTask(User assigner, CustomVehicleOrder customOrder) {
        super(assigner);

        if (customOrder == null) {
            throw new IllegalArgumentException(
                    "A custom vehicle order is required.");
        }

        this.customOrder = customOrder;
        this.make = customOrder.getMake();
        this.model = customOrder.getModel();
        this.status = OrderStatus.DRAFT;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Moves the order forward by exactly one approved lifecycle step.
     * A customer must meet the 10% deposit rule before validation.
     *
     * @return true if the status advanced; false if already delivered
     */
    public boolean advanceStatus() {
        switch (status) {
            case DRAFT:
                if (customOrder == null) {
                    throw new IllegalStateException(
                            "Complete customer-order details before validation.");
                }

                if (!customOrder.hasValidDeposit()) {
                    throw new IllegalStateException(
                            "A 10% deposit is required before validation.");
                }

                status = OrderStatus.VALIDATED;
                return true;

            case VALIDATED:
                status = OrderStatus.SOURCING_PARTS;
                return true;

            case SOURCING_PARTS:
                status = OrderStatus.READY_FOR_PRODUCTION;
                return true;

            case READY_FOR_PRODUCTION:
                status = OrderStatus.IN_PRODUCTION;
                return true;

            case IN_PRODUCTION:
                status = OrderStatus.IN_TRANSIT;
                return true;

            case IN_TRANSIT:
                status = OrderStatus.DELIVERED;
                return true;

            case DELIVERED:
                return false;

            default:
                throw new IllegalStateException("Unknown order status.");
        }
    }
/**
 * Marks a validated custom order as actively being built by Production.
 */
public void markInProduction() {
    if (customOrder == null) {
        throw new IllegalStateException(
                "Only a detailed custom order can enter Production.");
    }

    status = OrderStatus.IN_PRODUCTION;
}

/**
 * Marks a completed vehicle as in transit with Manufacturer Logistics.
 */
public void markInTransit() {
    if (customOrder == null) {
        throw new IllegalStateException(
                "Only a detailed custom order can enter transit.");
    }

    status = OrderStatus.IN_TRANSIT;
}    
    /**
     * Marks this customer order delivered after Manufacturer Logistics confirms
     * receipt at the destination dealership.
     */
    public void markDelivered() {
        if (customOrder == null) {
            throw new IllegalStateException(
                    "Only a detailed custom order can be marked delivered.");
        }

        status = OrderStatus.DELIVERED;
    }
    /**
     * Checks whether German production is complete.
     * Production is complete once the vehicle enters transit.
     *
     * @return true when the vehicle is in transit or delivered
     */
    public boolean orderBuild() {
        return status == OrderStatus.IN_TRANSIT
                || status == OrderStatus.DELIVERED;
    }

    /**
     * Returns a short order label for a table or work-area display.
     *
     * @return the custom-order ID when available, otherwise a basic vehicle label
     */
    public String getOrderDisplayName() {
        if (customOrder != null) {
            return customOrder.getOrderId() + " - "
                    + customOrder.getVehicleDescription();
        }

        return make + " " + model;
    }
}
