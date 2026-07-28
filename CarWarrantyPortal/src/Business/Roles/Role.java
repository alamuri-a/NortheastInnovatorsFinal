/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Alamuri
 */
public abstract class Role {
    
    // ATTRIBUTES
    JPanel workArea;
    
    // CONSTRUCTORS
    public Role(JPanel area) {
        this.workArea = area;
    }
    
    // METHODS
    /**
    * Loads role work area into UI
    * 
    * @param workAreaContainer container that holds the card layout for workflow
    */
    public void loadWorkArea(JPanel workAreaContainer) {
        workAreaContainer.removeAll();
        workAreaContainer.add(workArea, "WorkAreaLandingPage");
        ((CardLayout) workAreaContainer.getLayout()).next(workAreaContainer);
    }
}
