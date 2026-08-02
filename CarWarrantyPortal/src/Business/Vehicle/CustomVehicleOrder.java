/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Vehicle;

/**
 *
 * @author nicholaswoodward
 */
/**
 * Stores the business data for one customer-designed vehicle order.
 * This class supports Use Case 1: Custom Vehicle Order and Global
 * Supply Chain Fulfillment.
 *
 * The related SellVehicleTask manages the order workflow status.
 */
public class CustomVehicleOrder {
    // Generates a unique human-readable ID for each custom vehicle order.
    private static int orderCount = 1000;
// Generates a unique numeric VIN for each custom vehicle in this demo.
    private static int nextVehicleVin = 700000;
    private final String orderId;
    // VIN assigned to the vehicle produced for this custom order.
    private final int vehicleVin;
    private final String customerName;
    private final String customerEmail;
    private final String make;
    private final String model;
    private final String trim;
    private final String color;
    private final String supplierRegion;
    private final String manufacturerCountry;
    private final double totalPrice;
    private final double depositPaid;
/**
 * Creates a validated custom vehicle order.
 *
 * @param customerName name of the customer placing the order
 * @param customerEmail customer contact email
 * @param make vehicle manufacturer
 * @param model selected vehicle model
 * @param trim selected trim level
 * @param color selected exterior color
 * @param supplierRegion region supplying international components
 * @param totalPrice full vehicle price in USD
 * @param depositPaid customer deposit paid in USD
 * @throws IllegalArgumentException if required information, email,
 *         price, or deposit values are invalid
 */    
    public CustomVehicleOrder(
            String customerName,
            String customerEmail,
            String make,
            String model,
            String trim,
            String color,
            String supplierRegion,
            double totalPrice,
            double depositPaid) {

        validateText(customerName, "Customer name");
        validateEmail(customerEmail);
        validateText(make, "Make");
        validateText(model, "Model");
        validateText(trim, "Trim");
        validateText(color, "Color");
        validateText(supplierRegion, "Supplier region");

        if (totalPrice <= 0) {
            throw new IllegalArgumentException(
                    "Vehicle price must be greater than zero.");
        }

        if (depositPaid < 0 || depositPaid > totalPrice) {
            throw new IllegalArgumentException(
                    "Deposit must be between zero and the vehicle price.");
        }

        this.orderId = "CVO-" + (++orderCount);
        this.vehicleVin = ++nextVehicleVin;
        this.customerName = customerName.trim();
        this.customerEmail = customerEmail.trim();
        this.make = make.trim();
        this.model = model.trim();
        this.trim = trim.trim();
        this.color = color.trim();
        this.supplierRegion = supplierRegion.trim();
        this.manufacturerCountry = "Germany";
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
    }

    private void validateText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException(
                    "Enter a valid customer email address.");
        }
    }

    public String getOrderId() {
        return orderId;
    }
    /**
 * Returns the VIN assigned to this custom-built vehicle.
 *
 * @return numeric vehicle identification number
 */
public int getVehicleVin() {
    return vehicleVin;
}

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public String getColor() {
        return color;
    }

    public String getSupplierRegion() {
        return supplierRegion;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDepositPaid() {
        return depositPaid;
    }
/**
 * Checks the business rule that a customer must pay at least 10%
 * of the vehicle price before the order can be validated.
 *
 * @return true when the deposit meets the required minimum
 */
    public boolean hasValidDeposit() {
        return depositPaid >= totalPrice * 0.10;
    }
/**
 * Creates a short vehicle label for tables and work-area displays.
 *
 * @return make, model, and trim combined into one description
 */
    public String getVehicleDescription() {
        return make + " " + model + " " + trim;
    }
}
