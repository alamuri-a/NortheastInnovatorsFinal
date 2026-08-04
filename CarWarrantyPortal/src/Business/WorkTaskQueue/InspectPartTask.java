/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.Part;

/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 */
public class InspectPartTask extends WorkTask {
    // ATTRIBUTES
    private Part part;
    private OrderStatus result; // UPDATED: Changed from String to OrderStatus enum
    private String qaMessage;

    // CONSTRUCTORS
    public InspectPartTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
        this.result = OrderStatus.PENDING; // UPDATED: Initialized with Enum constant instead of "Pending"
        this.qaMessage = "";
    }

    // METHODS
    /**
     * Deny shipping of part due to defects
     *
     * @return True if part is not working, False if part is working
     */
    public boolean deny() {
        if (part != null && !part.isWorking()) {
            return true;
        }
        // UPDATED: Direct comparison with the enum type instead of .equalsIgnoreCase()
        return this.result == OrderStatus.QA_FAILED || this.result == OrderStatus.QA_FAILED;
    }

    // UI FRAMEWORK BRIDGES (Maps your specific variables to Panel fields)
    public String getStatus() {
        return isCompleted() ? "Processed" : "Pending QA Review";
    }

    public String getMessage() {
        return this.qaMessage;
    }

    public void setMessage(String message) {
        this.qaMessage = message;
    }

    // UI FIELD CAPTURE WRAPPERS
    public String getPartName() {
        return (part != null) ? "Part Number " + part.getId() : "Unknown Part";
    }

    public String getPartTestingStatus() {
        if (part == null) return "N/A";
        return part.isWorking() ? "STATUS: Functional" : "STATUS: Defective";
    }

    // GETTERS & SETTERS
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public OrderStatus getResult() { // UPDATED: Return type changed to OrderStatus
        return result;
    }

    public void setResult(OrderStatus result) { // UPDATED: Now matches your requested signature
        this.result = result;
    }

    @Override
    public String toString(){
        return (part != null) ? "Part Number " + part.getId() : "Unknown Part";
    }
}
