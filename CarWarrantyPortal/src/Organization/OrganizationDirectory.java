/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization;

import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class OrganizationDirectory {
    
    // ATTRIBUTES
    ArrayList<Organization> organizations;
    
    // CONSTRUCTORS
    public OrganizationDirectory() {
        this.organizations = new ArrayList();
    }
    
    // METHODS
    public Organization FindOrganization(int oID) {
        for (Organization org : organizations) {
            if (org.GetID() == oID) return org;
        }
        return null;
    }
    
    public Organization CreateOrganization(String oName) {
        Organization newOrganization = new Organization(oName);
        this.organizations.add(newOrganization);
        return newOrganization;
    }
    
    public void RemoveOrganization(Organization o) {
        this.organizations.remove(o);
    }
}
