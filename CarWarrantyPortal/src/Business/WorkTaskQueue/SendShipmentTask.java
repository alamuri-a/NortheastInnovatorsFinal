/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.Enterprise.DealershipEnterprise;
import Business.User.User;
import Business.Vehicle.Part;

/**
 *
 * @author Ajay Alamuri
 */
public class SendShipmentTask extends WorkTask {
    
    // ATTRIBUTES
    Part part;
    int partCount;
    DealershipEnterprise dealership;
    
    // CONSTRUCTORS
    public SendShipmentTask(User assigner, DealershipEnterprise dealer, Part pt, int quantity) {
        super(assigner);
        this.dealership = dealer;
        this.part = pt;
        this.partCount = quantity;
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Send Shipment";
    }

    public Part getPart() {
        return part;
    }

    public int getPartCount() {
        return partCount;
    }

    public DealershipEnterprise getDealership() {
        return dealership;
    }
}
