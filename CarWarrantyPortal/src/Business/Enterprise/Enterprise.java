/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.AdminOrganization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 */
public abstract class Enterprise {
    
    // ATTRIBUTES
    int id;
    String name;
    OrganizationDirectory organizations;
    AdminOrganization admins;
    private Type enterpriseType;
    static int instances = 0;
    
    // CONSTRUCTORS
    public Enterprise(String n) {
        this.name = n;
        this.id = ++instances;
        this.admins = new AdminOrganization(this);
        this.organizations = new OrganizationDirectory(this);
    }
    
    // METHODS
       public enum Type{
        Manu("Manufacturer"),
        Dealer("Dealership"),
        Supplier("Supplier");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    @Override
    public String toString() {
        return value; // Makes the combo box display "Manufacturer" cleanly
    }
    }
    @Override
    public String toString() {
        return this.name;
    }
    public abstract Type getEnterpriseType();
        
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String n) {
        this.name = n;
    }

    public OrganizationDirectory getOrganizations() {
        return organizations;
    }

    public void setOrganizations(OrganizationDirectory organizations) {
        this.organizations = organizations;
    }

    public AdminOrganization getAdmins() {
        return admins;
    }

    public void setAdmins(AdminOrganization admins) {
        this.admins = admins;
    }
       
}
