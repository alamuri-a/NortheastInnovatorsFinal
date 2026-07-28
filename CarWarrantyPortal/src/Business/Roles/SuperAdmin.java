/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

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
        super(new SuperAdminWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Super Admin";
    }
}
