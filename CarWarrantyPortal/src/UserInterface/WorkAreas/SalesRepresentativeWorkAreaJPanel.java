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
import javax.swing.JLabel;
import javax.swing.JButton;
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
    }    /**
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
