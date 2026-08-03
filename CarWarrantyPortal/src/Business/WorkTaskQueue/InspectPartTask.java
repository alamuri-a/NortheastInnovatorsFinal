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

    private String result;    // Tracks inspector decision: "Pass" or "Fail"
    private String qaMessage; // Form comment storage field for inspector notes
    // CONSTRUCTORS
    public InspectPartTask(User assigner, Part pt) {
        super(assigner);      // Calls parent constructor (sets unique ID, completes = false)
        this.part = pt;
        this.result = "Pending";
        this.qaMessage = "";
    }

    // METHODS

    /**
     * Deny shipping of part due to defects
     *
     * @return True if part is not working, False if part is working
     */
   
    public boolean deny() {
        // Leverages your Part class's intrinsic operational health status
        if (part != null && !part.isWorking()) {
            return true;
        }
        // Also denies if explicitly failed by the inspector during audit
        return "Fail".equalsIgnoreCase(this.result);
    }

    // UI FRAMEWORK BRIDGES (Maps your specific variables to Panel fields)
    public String getStatus() {
        // Formulates a user-friendly string from your parent's boolean 'completed' flag
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

    public String getPartSerialNumber() {
        if (part == null) return "N/A";
        // Provides a clear descriptive string based on the part's native operational health
        return part.isWorking() ? "STATUS: Functional" : "STATUS: Defective";
    }

    // GETTERS & SETTERS
    public Part getPart() { return part; }
    public void setPart(Part part) { this.part = part; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
