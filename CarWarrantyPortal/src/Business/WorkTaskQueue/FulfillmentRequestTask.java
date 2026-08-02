package Business.WorkTaskQueue;

import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;

/**
 * Represents one cross-organization fulfillment request created from a
 * customer custom vehicle order.
 *
 * The same request is placed in the sending organization's out-queue and the
 * receiving organization's in-queue, making the international handoff visible
 * during the project demonstration.
 *
 * @author nicholaswoodward
 */
public class FulfillmentRequestTask extends WorkTask {

    // Customer order being fulfilled across the global supply chain.
    private CustomVehicleOrder customOrder;

    // Business action requested, such as supplier sourcing or vehicle production.
    private String requestType;

    // Names of the organizations participating in this request.
    private String sourceOrganization;
    private String destinationOrganization;

    // Current request state for reporting and demonstration.
    private String requestStatus;

    /**
     * Creates an open cross-organization fulfillment request.
     *
     * @param assigner user initiating the request
     * @param customOrder customer vehicle order being processed
     * @param requestType action requested from the receiving organization
     * @param sourceOrganization organization initiating the request
     * @param destinationOrganization organization receiving the request
     */
    public FulfillmentRequestTask(
            User assigner,
            CustomVehicleOrder customOrder,
            String requestType,
            String sourceOrganization,
            String destinationOrganization) {

        super(assigner);

        if (customOrder == null) {
            throw new IllegalArgumentException(
                    "A custom vehicle order is required.");
        }

        validateText(requestType, "Request type");
        validateText(sourceOrganization, "Source organization");
        validateText(destinationOrganization, "Destination organization");

        this.customOrder = customOrder;
        this.requestType = requestType.trim();
        this.sourceOrganization = sourceOrganization.trim();
        this.destinationOrganization = destinationOrganization.trim();
        this.requestStatus = "OPEN";
    }

    /**
     * Validates required request text values.
     *
     * @param value value to validate
     * @param fieldName user-facing field name
     */
    private void validateText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
    }

    public CustomVehicleOrder getCustomOrder() {
        return customOrder;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getSourceOrganization() {
        return sourceOrganization;
    }

    public String getDestinationOrganization() {
        return destinationOrganization;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * Marks this handoff request complete after the receiving organization
     * finishes the requested action.
     */
    public void completeRequest() {
        requestStatus = "COMPLETED";
        Complete();
    }

    /**
     * Creates a readable queue label for the request.
     *
     * @return order ID and requested fulfillment action
     */
    @Override
    public String toString() {
        return customOrder.getOrderId() + " - " + requestType;
    }
}
