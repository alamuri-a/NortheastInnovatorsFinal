/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

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
    public abstract void LoadWorkArea();
}
