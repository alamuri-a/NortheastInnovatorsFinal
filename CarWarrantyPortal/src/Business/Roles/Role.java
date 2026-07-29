/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Ecosystem.Ecosystem;
import Business.Organization.Organization;
import Business.User.User;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Alamuri
 */
public abstract class Role {
    
    // ATTRIBUTES
    
    // CONSTRUCTORS
    
    // METHODS
    /**
    * Loads role work area into UI
    * 
    * @param workAreaContainer container that holds the card layout for workflow
    * 
    * @return JPanel with work area landing page
    */
    public abstract JPanel createWorkArea(JPanel workAreaContainer, User user, Organization organization, Ecosystem system);
}
