/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

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
        super(new AdminWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Admin";
    }
}
