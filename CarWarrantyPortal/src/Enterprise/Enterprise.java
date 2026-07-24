/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

import Organization.AdminOrganization;
import Organization.OrganizationDirectory;

/**
 *
 * @author Ajay Alamuri
 */
public class Enterprise {
    
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
        this.admins = new AdminOrganization(this.name + "Admins");
        this.organizations = new OrganizationDirectory();
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public String GetName() { return this.name; }
    
    public void SetName(String n) { this.name = n; }
    
}
