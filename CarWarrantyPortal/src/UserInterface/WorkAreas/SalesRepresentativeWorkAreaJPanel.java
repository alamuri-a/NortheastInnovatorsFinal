package UserInterface.WorkAreas;

import Business.Ecosystem.Ecosystem;
import Business.Organization.Organization;
import Business.User.User;
import Business.Vehicle.CustomVehicleOrder;
import Business.WorkTaskQueue.SellVehicleTask;
import Business.WorkTaskQueue.WorkTask;
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

    // Stores the visible order table and its data model for status updates.
    private DefaultTableModel tableModel;
    private JTable orderTable;
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

            tableModel.addRow(new Object[]{
                order.getOrderId(),
                order.getCustomerName(),
                order.getVehicleDescription(),
                order.getSupplierRegion(),
                order.getManufacturerCountry(),
                String.format("$%,.2f", order.getDepositPaid()),
                salesTask.getStatus()
            });

            clearOrderForm();

            JOptionPane.showMessageDialog(this,
                    "Custom order " + order.getOrderId()
                    + " was created with DRAFT status.",
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
                        boolean advanced = salesTask.advanceStatus();

                        if (advanced) {
                            tableModel.setValueAt(
                                    salesTask.getStatus(), modelRow, 6);

                            JOptionPane.showMessageDialog(this,
                                    orderId + " advanced to "
                                    + salesTask.getStatus() + ".",
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
