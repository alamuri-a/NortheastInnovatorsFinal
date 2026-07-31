/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Ecosystem.Ecosystem;
import Business.Organization.Organization;
import Business.User.User;
import UserInterface.WorkAreas.SuperAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class SuperAdmin extends Role {
    
    // ATTRIBUTES
    
    // CONSTRUCTORS
    public SuperAdmin() {
        super();
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Super Admin";
    }
    
    @Override
    public JPanel createWorkArea(JPanel workAreaContainer, User user, Organization organization, Ecosystem system) {
        return new SuperAdminWorkAreaJPanel(workAreaContainer,system);
    }
}
