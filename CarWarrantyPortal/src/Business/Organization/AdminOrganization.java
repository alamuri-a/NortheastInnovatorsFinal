/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.Enterprise;

/**
 *
 * @author Ajay Alamuri
 */
public class AdminOrganization extends Organization {
    
    // ATTRIBUTES
    
    // CONSTRUCTORS
    public AdminOrganization(Enterprise ent) {
        super("Admin", 0, ent);
    }
    
    // METHODS
}
