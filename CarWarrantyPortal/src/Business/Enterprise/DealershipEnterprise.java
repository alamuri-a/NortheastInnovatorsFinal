package Business.Enterprise;

import Business.Vehicle.Automobile;
import Business.WorkTaskQueue.SellVehicleTask;
import Business.WorkTaskQueue.WorkTask;
import Business.Vehicle.Part;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stores dealership-owned vehicles, sales orders, and service-related records.
 *
 * This enterprise represents the United States dealership in the Global Auto
 * Ecosystem. Sales and service organizations use these collections as the
 * dealership's shared business records.
 *
 * @author Ajay Alamuri
 * @author nicholaswoodward
 */
public class DealershipEnterprise extends Enterprise {

    // Vehicles currently owned, sold, or serviced by this dealership.
    private final ArrayList<Automobile> automobiles;

    // Customer vehicle-sale records created by the dealership sales team.
    private final ArrayList<SellVehicleTask> salesRecords;

    // Service, appointment, recall, or trade-in tasks related to dealership vehicles.
    private final ArrayList<WorkTask> serviceRecords;
    // Replacement-part inventory stored at this dealership service center.
    private final HashMap<Integer, Integer> partsInventory;
    /**
     * Creates a dealership enterprise with empty business-record collections.
     *
     * @param name dealership name
     */
    public DealershipEnterprise(String name) {
        super(name);
        this.automobiles = new ArrayList<>();
        this.salesRecords = new ArrayList<>();
        this.serviceRecords = new ArrayList<>();
        this.partsInventory = new HashMap<>();
    }

    /**
     * Adds a vehicle to the dealership record after confirming its VIN is unique.
     *
     * @param automobile vehicle to retain in dealership records
     */
    public void addAutomobile(Automobile automobile) {
        if (automobile == null) {
            throw new IllegalArgumentException("Automobile is required.");
        }

        if (findAutomobileByVin(automobile.getVIN()) != null) {
            throw new IllegalArgumentException(
                    "A vehicle with this VIN already exists in the dealership.");
        }

        automobiles.add(automobile);
    }

    /**
     * Finds a dealership vehicle by its VIN.
     *
     * @param vin vehicle identification number
     * @return matching vehicle, or null when no vehicle has that VIN
     */
    public Automobile findAutomobileByVin(int vin) {
        for (Automobile automobile : automobiles) {
            if (automobile.getVIN() == vin) {
                return automobile;
            }
        }

        return null;
    }

    /**
     * Records a customer vehicle sale created by the Toyota Sales organization.
     *
     * @param salesTask completed or active customer sales task
     */
    public void addSalesRecord(SellVehicleTask salesTask) {
        if (salesTask == null) {
            throw new IllegalArgumentException("Sales task is required.");
        }

        salesRecords.add(salesTask);
    }

    /**
     * Records a dealership service-related work task.
     *
     * @param serviceTask appointment, service, recall, or trade-in task
     */
    public void addServiceRecord(WorkTask serviceTask) {
        if (serviceTask == null) {
            throw new IllegalArgumentException("Service record is required.");
        }

        serviceRecords.add(serviceTask);
    }

    /**
     * Returns dealership vehicle records for display and reporting.
     *
     * @return read-only automobile list
     */
    public List<Automobile> getAutomobiles() {
        return Collections.unmodifiableList(automobiles);
    }

    /**
     * Returns dealership customer sales records for display and reporting.
     *
     * @return read-only sales record list
     */
    public List<SellVehicleTask> getSalesRecords() {
        return Collections.unmodifiableList(salesRecords);
    }

    /**
     * Returns dealership service-related records for display and reporting.
     *
     * @return read-only service record list
     */
    public List<WorkTask> getServiceRecords() {
        return Collections.unmodifiableList(serviceRecords);
    }
   /**
 * Returns the current quantity of a replacement part stored at the dealership.
 *
 * @param part replacement part to look up
 * @return stored quantity, or zero when the part has not been received
 */
public int getPartQuantity(Part part) {
    if (part == null) {
        throw new IllegalArgumentException("Part is required.");
    }

    Integer quantity = partsInventory.get(part.getId());
    return quantity == null ? 0 : quantity;
}

/**
 * Updates the stored quantity of a replacement part at the dealership.
 *
 * @param part replacement part being stored
 * @param quantity non-negative replacement-part quantity
 */
public void setPartQuantity(Part part, int quantity) {
    if (part == null || quantity < 0) {
        throw new IllegalArgumentException(
                "A part and non-negative quantity are required.");
    }

    partsInventory.put(part.getId(), quantity);
}

/**
 * Adds received replacement parts to the dealership inventory.
 *
 * @param part replacement part received from Supplier Logistics
 * @param quantity quantity received
 */
public void addPartQuantity(Part part, int quantity) {
    if (part == null || quantity <= 0) {
        throw new IllegalArgumentException(
                "A part and positive quantity are required.");
    }

    setPartQuantity(part, getPartQuantity(part) + quantity);
} 
}
