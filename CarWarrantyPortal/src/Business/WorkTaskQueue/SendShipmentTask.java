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
    private Part part;
    private int partCount;
    private DealershipEnterprise dealership;
    private GetPartTask retrieval;
    
    // CONSTRUCTORS
    public SendShipmentTask(User assigner, DealershipEnterprise dealer, Part pt, int quantity) {
        super(assigner);
        this.dealership = dealer;
        this.part = pt;
        this.partCount = quantity;
        this.retrieval = null;
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

    public GetPartTask getRetrieval() {
        return retrieval;
    }

    public void setRetrieval(GetPartTask retrieval) {
        this.retrieval = retrieval;
    }
    
    public DealershipEnterprise getDealership() {
        return dealership;
    }
}
