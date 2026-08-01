package UserInterface.WorkAreas;

import Business.Ecosystem.Ecosystem;
import Business.Organization.Organization;
import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;
import Business.WorkTaskQueue.SellVehicleTask;
import Business.WorkTaskQueue.WorkTask;
import Business.Ecosystem.Network;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrganization;
import Business.Organization.ProductionOrganization;
import Business.Organization.WarehousingOrganization;
import Business.WorkTaskQueue.FulfillmentRequestTask;
import Business.WorkTaskQueue.OrderStatus;
import Business.Enterprise.DealershipEnterprise;
import Business.Vehicle.Part;
import Business.WorkTaskQueue.BuildCarTask;
import Business.WorkTaskQueue.GetPartTask;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Displays Toyota Dealership custom vehicle orders for the Sales
 * Representative role.
 *
 * @author Ajay Alamuri
 * @author nicholaswoodward
 */
public class SalesRepresentativeWorkAreaJPanel extends JPanel {
    // Stores the sales organization whose orders appear in this dashboard.
    private Organization salesOrganization;
    // Gives this dashboard access to supplier, production, and logistics teams.
    private Ecosystem ecosystem;
    // Stores the visible order table and its data model for status updates.
    private DefaultTableModel tableModel;
    private JTable orderTable;
    // Dashboard values that summarize Faker and user-created dealership orders.
    private JLabel totalOrdersValueLabel;
    private JLabel totalDepositsValueLabel;
    private JLabel inProductionValueLabel;
    private JLabel inTransitValueLabel;
    private JLabel deliveredValueLabel;
    // Stores the logged-in representative who creates dealership orders.
    private User salesRepresentative;
    // Stores custom-order form inputs.
    private JTextField customerNameField;
    private JTextField customerEmailField;
    private JTextField priceField;
    private JTextField depositField;
    private JComboBox<String> modelComboBox;
    private JComboBox<String> trimComboBox;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> supplierComboBox;
    /**
     * Creates the Sales Representative dealership work area.
     *
     * @param workAreaContainer application panel that holds role work areas
     * @param user logged-in Sales Representative
     * @param organization Toyota Sales organization
     * @param system Global Auto Ecosystem
     */
    public SalesRepresentativeWorkAreaJPanel(
            JPanel workAreaContainer,
            User user,
            Organization organization,
            Ecosystem system) {
        this.salesOrganization = organization;
        this.ecosystem = system;
        this.salesRepresentative = user;
        buildCustomOrderScreen(organization);
    }

    /**
     * Builds the custom-order heading and dealership order-tracking table.
     *
     * @param salesOrganization Toyota Sales organization containing orders
     */
    private void buildCustomOrderScreen(Organization salesOrganization) {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(14, 14, 14, 14));
        setBackground(new Color(245, 247, 250));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(20, 36, 58));
        headerPanel.setBorder(new EmptyBorder(16, 20, 16, 20));

        JLabel titleLabel = new JLabel("Custom Vehicle Orders");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel(
                "US Sales -> Mexico / Asia Suppliers -> German Production");
        subtitleLabel.setForeground(new Color(210, 225, 240));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(titleLabel, BorderLayout.NORTH);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);
        add(headerPanel, BorderLayout.NORTH);

        JPanel trackingPanel = new JPanel(new BorderLayout(8, 8));
        trackingPanel.setBackground(Color.WHITE);
        trackingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
                "Toyota Dealership Order Tracker"));
        trackingPanel.add(buildAnalyticsPanel(), BorderLayout.NORTH);
        tableModel = new DefaultTableModel(
                new String[]{
                    "Order ID",
                    "Customer",
                    "Vehicle",
                    "Supplier Region",
                    "Production",
                    "Deposit",
                    "Status"
                }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (WorkTask workTask : salesOrganization.getOutTasks().getTasks()) {
            if (workTask instanceof SellVehicleTask) {
                SellVehicleTask salesTask = (SellVehicleTask) workTask;
                CustomVehicleOrder order = salesTask.getCustomOrder();

                if (order != null) {
                    tableModel.addRow(new Object[]{
                        order.getOrderId(),
                        order.getCustomerName(),
                        order.getVehicleDescription(),
                        order.getSupplierRegion(),
                        order.getManufacturerCountry(),
                        String.format("$%,.2f", order.getDepositPaid()),
                        salesTask.getStatus()
                    });
                }
            }
        }

        orderTable = new JTable(tableModel);
        orderTable.setAutoCreateRowSorter(true);

        JLabel informationLabel = new JLabel(
                "Six Faker-generated dealership orders are loaded for "
                + "the project demonstration.");

                JButton advanceStatusButton = new JButton("Advance Selected Order");
                advanceStatusButton.addActionListener(event -> advanceSelectedOrder());

                JPanel bottomPanel = new JPanel(new BorderLayout());
                bottomPanel.setOpaque(false);
                bottomPanel.add(informationLabel, BorderLayout.WEST);
                bottomPanel.add(advanceStatusButton, BorderLayout.EAST);

                trackingPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);
                trackingPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(trackingPanel, BorderLayout.CENTER);
        add(buildOrderFormPanel(), BorderLayout.SOUTH);
    }  
        /**
     * Builds the form a Sales Representative uses to create a dealership
     * custom vehicle order.
     *
     * @return completed custom-order form panel
     */
    private JPanel buildOrderFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(0, 4, 8, 6));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
                "Create New Toyota Custom Order"));

        customerNameField = new JTextField();
        customerEmailField = new JTextField();
        priceField = new JTextField("42000");
        depositField = new JTextField("5000");

        modelComboBox = new JComboBox<>(new String[]{
            "Camry", "RAV4", "Highlander", "Prius"
        });
        trimComboBox = new JComboBox<>(new String[]{
            "LE", "XLE", "Limited", "Hybrid"
        });
        colorComboBox = new JComboBox<>(new String[]{
            "Midnight Black", "Ice Cap", "Supersonic Red", "Celestial Silver"
        });
        supplierComboBox = new JComboBox<>(new String[]{
            "Mexico", "Asia", "Mexico and Asia"
        });

        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(customerNameField);
        formPanel.add(new JLabel("Customer Email:"));
        formPanel.add(customerEmailField);

        formPanel.add(new JLabel("Toyota Model:"));
        formPanel.add(modelComboBox);
        formPanel.add(new JLabel("Trim:"));
        formPanel.add(trimComboBox);

        formPanel.add(new JLabel("Color:"));
        formPanel.add(colorComboBox);
        formPanel.add(new JLabel("Supplier Region:"));
        formPanel.add(supplierComboBox);

        formPanel.add(new JLabel("Vehicle Price:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Deposit Paid:"));
        formPanel.add(depositField);

        JButton createOrderButton = new JButton("Create Draft Order");
        createOrderButton.addActionListener(event -> createCustomOrder());
        formPanel.add(createOrderButton);

        return formPanel;
    }
        /**
     * Validates form values, creates a DRAFT dealership order, and adds it
     * to the Sales Organization tracker.
     */
    private void createCustomOrder() {
        try {
            double vehiclePrice = Double.parseDouble(
                    priceField.getText().trim());
            double depositPaid = Double.parseDouble(
                    depositField.getText().trim());

            CustomVehicleOrder order = new CustomVehicleOrder(
                    customerNameField.getText(),
                    customerEmailField.getText(),
                    "Toyota",
                    (String) modelComboBox.getSelectedItem(),
                    (String) trimComboBox.getSelectedItem(),
                    (String) colorComboBox.getSelectedItem(),
                    (String) supplierComboBox.getSelectedItem(),
                    vehiclePrice,
                    depositPaid);

            SellVehicleTask salesTask = new SellVehicleTask(
                    salesRepresentative, order);

            salesOrganization.getOutTasks().pushTask(salesTask);
            if (salesOrganization.getCompany() instanceof DealershipEnterprise) {
                DealershipEnterprise dealership
                    = (DealershipEnterprise) salesOrganization.getCompany();
                dealership.addSalesRecord(salesTask);
}

String dispatchMessage = dispatchInitialOrderTasks(salesTask);

            tableModel.addRow(new Object[]{
                order.getOrderId(),
                order.getCustomerName(),
                order.getVehicleDescription(),
                order.getSupplierRegion(),
                order.getManufacturerCountry(),
                String.format("$%,.2f", order.getDepositPaid()),
                salesTask.getStatus()
            });
            refreshAnalytics();
            clearOrderForm();

            JOptionPane.showMessageDialog(this,
                    "Custom order " + order.getOrderId()
                    + " was created with DRAFT status."
                    + dispatchMessage,
                    "Order Created",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this,
                    "Vehicle price and deposit must be valid numbers.",
                    "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(this,
                    exception.getMessage(),
                    "Invalid Order",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears form values after a new dealership order is created.
     */
    private void clearOrderForm() {
        customerNameField.setText("");
        customerEmailField.setText("");
        priceField.setText("42000");
        depositField.setText("5000");
        modelComboBox.setSelectedIndex(0);
        trimComboBox.setSelectedIndex(0);
        colorComboBox.setSelectedIndex(0);
        supplierComboBox.setSelectedIndex(0);
    }
    /**
     * Advances the selected custom vehicle order by one approved workflow
     * status and refreshes the visible tracker.
     */
    private void advanceSelectedOrder() {
        int selectedRow = orderTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Select an order from the table first.",
                    "No Order Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int modelRow = orderTable.convertRowIndexToModel(selectedRow);
        String orderId = String.valueOf(tableModel.getValueAt(modelRow, 0));

        for (WorkTask workTask : salesOrganization.getOutTasks().getTasks()) {
            if (workTask instanceof SellVehicleTask) {
                SellVehicleTask salesTask = (SellVehicleTask) workTask;
                CustomVehicleOrder order = salesTask.getCustomOrder();

                if (order != null && order.getOrderId().equals(orderId)) {
                    try {
                        OrderStatus previousStatus = salesTask.getStatus();
                        boolean advanced = salesTask.advanceStatus();
                        String handoffMessage = advanced
                                ? describeWorkflowStep(
                                        salesTask, previousStatus)
                                : "";

                        if (advanced) {
                            tableModel.setValueAt(
                                    salesTask.getStatus(), modelRow, 6);
                            refreshAnalytics();
                            JOptionPane.showMessageDialog(this,
                                    orderId + " advanced to "
                                    + salesTask.getStatus() + "."
                                    + handoffMessage,
                                    "Order Updated",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this,
                                    orderId + " has already been delivered.",
                                    "Order Complete",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (IllegalStateException exception) {
                        JOptionPane.showMessageDialog(this,
                                exception.getMessage(),
                                "Order Cannot Advance",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    return;
                }
            }
        }
    }
        /**
     * Creates the next cross-organization fulfillment request after an order
     * advances through the global supply-chain workflow.
     *
     * @param salesTask order whose workflow state changed
     * @param previousStatus status held before the order advanced
     * @return short message describing the created handoff, when applicable
     */
   /**
 * Creates real cross-enterprise tasks when a dealership customer submits
 * a custom vehicle order.
 *
 * @param salesTask newly created customer sales task
 * @return summary of dispatched Warehouse and Production work
 */
private String dispatchInitialOrderTasks(SellVehicleTask salesTask) {
    CustomVehicleOrder order = salesTask.getCustomOrder();

    Organization warehouse = findOrganization(
            WarehousingOrganization.class);
    Organization production = findOrganization(
            ProductionOrganization.class);

    if (order == null || warehouse == null || production == null) {
        throw new IllegalStateException(
                "Warehouse and Production organizations are required "
                + "to dispatch a custom order.");
    }

    try {
        int partNumber = 1000
                + Math.abs(order.getOrderId().hashCode() % 9000);

        Part componentKit = new Part(partNumber);

        GetPartTask partsRequest
                = warehouse.getInTasks().createGetPartTask(
                        salesRepresentative,
                        componentKit,
                        4,
                        order);

        BuildCarTask productionRequest
                = new BuildCarTask(salesRepresentative, order);

        production.getInTasks().pushTask(productionRequest);

        // Sales keeps outbound references for reporting and traceability.
        salesOrganization.getOutTasks().pushTask(partsRequest);
        salesOrganization.getOutTasks().pushTask(productionRequest);

        return "\nParts request sent to " + warehouse.getName()
                + " and vehicle build sent to "
                + production.getName() + ".";

    } catch (Exception exception) {
        throw new IllegalStateException(
                "The custom order could not be dispatched.", exception);
    }
}

/**
 * Explains the next lifecycle stage without sending incompatible generic
 * tasks into role-specific queues.
 *
 * @param salesTask customer sales task being advanced
 * @param previousStatus status held before the advance
 * @return short explanation for the Sales Representative
 */
private String describeWorkflowStep(
        SellVehicleTask salesTask,
        OrderStatus previousStatus) {

    switch (previousStatus) {
        case DRAFT:
            return "\nThe order is validated. Warehouse and Production "
                    + "tasks were created when the order was submitted.";

        case VALIDATED:
            return "\nSupplier Warehouse is sourcing the required components.";

        case SOURCING_PARTS:
            return "\nComponents are ready for German Production.";

        case READY_FOR_PRODUCTION:
            return "\nGerman Production is building the vehicle.";

        case IN_PRODUCTION:
            return "\nProduction is complete and the vehicle is ready "
                    + "for international delivery.";

        case IN_TRANSIT:
            return "\nVehicle delivered to the dealership.";

        default:
            return "";
    }
} 
    /**
     * Locates the first organization of the requested type in the ecosystem.
     *
     * @param organizationType type of organization to locate
     * @return matching organization, or null when unavailable
     */
    private Organization findOrganization(
            Class<? extends Organization> organizationType) {

        for (Network network : ecosystem.getNetworks()) {
            for (Enterprise enterprise
                    : network.getEnterprises().getEnterprises()) {
                for (Organization organization
                        : enterprise.getOrganizations().getOrganizations()) {
                    if (organizationType.isInstance(organization)) {
                        return organization;
                    }
                }
            }
        }

        return null;
    }
    /**
     * Builds the dealership order metrics displayed above the tracker table.
     *
     * @return panel containing summarized order analytics
     */
    private JPanel buildAnalyticsPanel() {
        JPanel analyticsPanel = new JPanel(new GridLayout(1, 5, 8, 0));
        analyticsPanel.setBackground(new Color(245, 247, 250));
        analyticsPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

        totalOrdersValueLabel = new JLabel("0", SwingConstants.CENTER);
        totalDepositsValueLabel = new JLabel("$0.00", SwingConstants.CENTER);
        inProductionValueLabel = new JLabel("0", SwingConstants.CENTER);
        inTransitValueLabel = new JLabel("0", SwingConstants.CENTER);
        deliveredValueLabel = new JLabel("0", SwingConstants.CENTER);

        analyticsPanel.add(createMetricPanel(
                "Total Orders", totalOrdersValueLabel));
        analyticsPanel.add(createMetricPanel(
                "Deposits Collected", totalDepositsValueLabel));
        analyticsPanel.add(createMetricPanel(
                "In Production", inProductionValueLabel));
        analyticsPanel.add(createMetricPanel(
                "In Transit", inTransitValueLabel));
        analyticsPanel.add(createMetricPanel(
                "Delivered", deliveredValueLabel));

        refreshAnalytics();
        return analyticsPanel;
    }

    /**
     * Creates one labeled analytics metric for the dealership dashboard.
     *
     * @param title metric label
     * @param valueLabel visible value for the metric
     * @return formatted metric panel
     */
    private JPanel createMetricPanel(String title, JLabel valueLabel) {
        JPanel metricPanel = new JPanel(new BorderLayout());
        metricPanel.setBackground(Color.WHITE);
        metricPanel.setBorder(new EmptyBorder(6, 6, 6, 6));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        valueLabel.setForeground(new Color(20, 80, 130));

        metricPanel.add(titleLabel, BorderLayout.NORTH);
        metricPanel.add(valueLabel, BorderLayout.CENTER);

        return metricPanel;
    }

    /**
     * Recalculates dealership order totals from the Sales Organization queue.
     */
    private void refreshAnalytics() {
        int totalOrders = 0;
        int inProductionOrders = 0;
        int inTransitOrders = 0;
        int deliveredOrders = 0;
        double totalDeposits = 0.0;

        for (WorkTask workTask : salesOrganization.getOutTasks().getTasks()) {
            if (workTask instanceof SellVehicleTask) {
                SellVehicleTask salesTask = (SellVehicleTask) workTask;
                CustomVehicleOrder order = salesTask.getCustomOrder();

                if (order != null) {
                    totalOrders++;
                    totalDeposits += order.getDepositPaid();

                    if (salesTask.getStatus()
                            == OrderStatus.IN_PRODUCTION) {
                        inProductionOrders++;
                    } else if (salesTask.getStatus()
                            == OrderStatus.IN_TRANSIT) {
                        inTransitOrders++;
                    } else if (salesTask.getStatus()
                            == OrderStatus.DELIVERED) {
                        deliveredOrders++;
                    }
                }
            }
        }

        totalOrdersValueLabel.setText(String.valueOf(totalOrders));
        totalDepositsValueLabel.setText(
                String.format("$%,.2f", totalDeposits));
        inProductionValueLabel.setText(
                String.valueOf(inProductionOrders));
        inTransitValueLabel.setText(
                String.valueOf(inTransitOrders));
        deliveredValueLabel.setText(
                String.valueOf(deliveredOrders));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 153, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
