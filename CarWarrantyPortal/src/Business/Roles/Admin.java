/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Ecosystem.Ecosystem;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.User.User;
import UserInterface.WorkAreas.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class Admin extends Role {
    
    // ATTRIBUTES
    
    // CONSTRUCTORS
    public Admin() {
        super();
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Admin";
    }
    
    @Override
    public JPanel createWorkArea(JPanel workAreaContainer, User user, Organization organization, Ecosystem system) {
        return new AdminWorkAreaJPanel(workAreaContainer, user, organization, system);
    }
}
