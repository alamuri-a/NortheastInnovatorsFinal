package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.Part;

/**
 *
 * @author Ajay Alamuri
 * @author Nicholas Woodward
 */
public class BuildPartTask extends WorkTask {
    // ATTRIBUTES
    private Part part;
    private String message;
    private OrderStatus status; // Enum type tracking field

    // CONSTRUCTORS
    public BuildPartTask(User assigner, Part pt) {
        super(assigner);
        this.part = pt;
        this.status = OrderStatus.PENDING; // FIXED: Assigning the Enum value directly instead of a String
        this.message = "";
    }

    /**
     * Returns the component being built by Production.
     *
     * @return requested part
     */
    public Part getPart() {
        return part;
    }

    /**
     * Returns a readable Production queue label.
     *
     * @return part-build description
     */
    @Override
    public String toString() {
        return "Build " + part;
    }

    // GETTERS & SETTERS

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderStatus getStatus() {
        // Safe check: returns a default state if the task has no status assigned yet
        return (status == null) ? OrderStatus.PENDING : status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
