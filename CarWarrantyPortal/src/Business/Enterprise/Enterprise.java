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
 */
public abstract class Enterprise {
    
    // ATTRIBUTES
    int id;
    String name;
    OrganizationDirectory organizations;
    AdminOrganization admins;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public Enterprise(String n) {
        this.name = n;
        this.id = ++instances;
        this.admins = new AdminOrganization(this);
        this.organizations = new OrganizationDirectory(this);
    }
    
    // METHODS
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
