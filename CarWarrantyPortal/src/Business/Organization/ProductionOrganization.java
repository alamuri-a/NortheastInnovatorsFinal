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
public class ProductionOrganization extends Organization {
    
    // ATTRIBUTES
    
    // CONSTRUCTOR
    public ProductionOrganization(String n, int id, Enterprise company) {
        super(n, id, company);
    }
    
    // METHODS
    @Override
    public String toString() {
        return this.name;
    }
}
