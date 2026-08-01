/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.ProductionMgr;

import Business.Ecosystem.Ecosystem;
import Business.Organization.ProductionOrganization;
import Business.User.User;
import Business.WorkTaskQueue.BuildPartTask;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Business.Ecosystem.Network;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.Roles.ProductionManager;
import Business.WorkTaskQueue.ProcessShipmentTask;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Meredith Molyneux
 * @author Nicholas Woodward
 */
public class NewPartJPanel extends javax.swing.JPanel {
                  // ATTRIBUTES
    ProductionOrganization organization;
    JPanel workArea;
    User user;
    Ecosystem business;
    BuildPartTask task;

    /**
     * Creates new form NewOrderJPanel
     */
    public NewPartJPanel(JPanel csp, User usr, ProductionOrganization org, Ecosystem system, BuildPartTask tsk) {
        this.organization = org;
        this.workArea = csp;
        this.user = usr;
        this.business = system;
        this.task =tsk;
        initComponents();
        buildPartProductionScreen();
        lblTitle.setText(this.organization.getName() + " - New Part Request");
    }
/**
 * Builds the Production screen for a back-ordered component.
 */
private void buildPartProductionScreen() {
    removeAll();
    setLayout(new BorderLayout());

    JPanel headerPanel = new JPanel(new BorderLayout());
    headerPanel.setBackground(new Color(76, 47, 112));
    headerPanel.setBorder(new EmptyBorder(16, 20, 16, 20));

    JLabel titleLabel = new JLabel("German Production — Component Build");
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel partLabel = new JLabel(task.getPart().toString());
    partLabel.setForeground(new Color(235, 220, 250));
    partLabel.setHorizontalAlignment(SwingConstants.CENTER);

    headerPanel.add(titleLabel, BorderLayout.NORTH);
    headerPanel.add(partLabel, BorderLayout.SOUTH);

    JLabel instructionsLabel = new JLabel(
            "Complete the part build to send the component to Supplier Logistics.");
    instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
    instructionsLabel.setBorder(new EmptyBorder(30, 20, 30, 20));

    JButton completePartButton = new JButton("Complete Component Build");
    completePartButton.addActionListener(event -> completePartBuild());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(completePartButton);

    add(headerPanel, BorderLayout.NORTH);
    add(instructionsLabel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    revalidate();
    repaint();
}

/**
 * Completes the Production part build and creates a Supplier Logistics
 * shipment request for inventory receipt.
 */
private void completePartBuild() {
    if (task.isCompleted()) {
        JOptionPane.showMessageDialog(
                this,
                "This component build has already been completed.",
                "Build Complete",
                JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    LogisticsOrganization logisticsOrganization
            = findLogisticsOrganization();

    if (logisticsOrganization == null) {
        JOptionPane.showMessageDialog(
                this,
                "Supplier Logistics could not be found.",
                "Logistics Unavailable",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        ProcessShipmentTask shipment
                = logisticsOrganization.getInTasks()
                        .createProcessShipmentTask(user, task.getPart());

        task.Complete();
        organization.getInTasks().popTask(task);
        organization.getOutTasks().pushTask(task);

        // Production retains an outbound record of the cross-enterprise handoff.
        organization.getOutTasks().pushTask(shipment);

        if (user.getRole() instanceof ProductionManager) {
            ProductionManager productionManager
                    = (ProductionManager) user.getRole();
            productionManager.setCurrentTask(null);
        }

        JOptionPane.showMessageDialog(
                this,
                "Component build completed and sent to "
                + logisticsOrganization.getName() + ".");

        workArea.remove(this);
        ((CardLayout) workArea.getLayout()).previous(workArea);

    } catch (Exception exception) {
        JOptionPane.showMessageDialog(
                this,
                exception.getMessage(),
                "Shipment Not Created",
                JOptionPane.ERROR_MESSAGE);
    }
}

/**
 * Finds the Supplier Logistics organization used to receive completed parts.
 *
 * @return Supplier Logistics organization, or null when unavailable
 */
private LogisticsOrganization findLogisticsOrganization() {
    for (Network network : business.getNetworks()) {
        for (Enterprise enterprise
                : network.getEnterprises().getEnterprises()) {
            for (Organization organization
                    : enterprise.getOrganizations().getOrganizations()) {
                if (organization instanceof LogisticsOrganization) {
                    return (LogisticsOrganization) organization;
                }
            }
        }
    }

    return null;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 153, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack1.setText("<<< Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 130, -1));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setText("<Org Name> New Part Request");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 660, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        ((CardLayout) workArea.getLayout()).previous(workArea);
    }//GEN-LAST:event_btnBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
