package Business.WorkTaskQueue;

import Business.Enterprise.DealershipEnterprise;
import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;

/**
 * Represents the final cross-enterprise delivery of a completed custom vehicle
 * from Manufacturer Logistics to the requesting Dealership.
 *
 * @author nicholaswoodward
 */
public class VehicleDeliveryTask extends WorkTask {

    private final CustomVehicleOrder customOrder;
    private final DealershipEnterprise destinationDealership;

    /**
     * Creates a delivery task for a completed customer vehicle order.
     *
     * @param assigner Production user releasing the vehicle
     * @param customOrder completed vehicle order
     * @param destinationDealership dealership receiving the vehicle
     */
    public VehicleDeliveryTask(
            User assigner,
            CustomVehicleOrder customOrder,
            DealershipEnterprise destinationDealership) {

        super(assigner);

        if (customOrder == null || destinationDealership == null) {
            throw new IllegalArgumentException(
                    "A completed order and destination dealership are required.");
        }

        this.customOrder = customOrder;
        this.destinationDealership = destinationDealership;
    }

    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    public DealershipEnterprise getDestinationDealership() {
        return destinationDealership;
    }

    @Override
    public String toString() {
        return customOrder.getOrderId()
                + " - Deliver vehicle to "
                + destinationDealership.getName();
    }
}
