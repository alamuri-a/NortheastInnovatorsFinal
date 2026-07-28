/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Enterprise.DealershipEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.SupplierEnterprise;
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class OrganizationDirectory {
    
    // ATTRIBUTES
    ArrayList<Organization> organizations;
    Enterprise company;
    int organizationCount;
    
    // CONSTRUCTORS
    public OrganizationDirectory(Enterprise ent) {
        this.company = ent;
        this.organizations = new ArrayList();
        this.organizationCount = 1;
    }
    
    // METHODS

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(ArrayList<Organization> organizations) {
        this.organizations = organizations;
    }

    public Enterprise getCompany() {
        return company;
    }

    public void setCompany(Enterprise company) {
        this.company = company;
    }

    public int getOrganizationCount() {
        return organizationCount;
    }
    
    /**
    * Gets organization with matching ID or returns NULL if no organization found with matching ID
    * 
    * @param oID the organization ID
    * 
    * @return {@link Organization} or NULL
    */
    public Organization findOrganization(int oID) {
        for (Organization org : organizations) {
            if (org.getID() == oID) return org;
        }
        return null;
    }
    
    /**
    * Create a new ProductionOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param poName the new organization's name
    * 
    * @return {@link ProductionOrganization} the new ProductionOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Manufacturer enterprise
    */
    public ProductionOrganization createProductionOrganization(String poName) throws Exception {
        if (this.company instanceof ManufacturerEnterprise) {
            ProductionOrganization newOrganization = new ProductionOrganization(poName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Production organization can only be created by Manufacturer enterprises.");
    }
    
    /**
    * Create a new QualityAssuranceOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param qaoName the new organization's name
    * 
    * @return {@link QualityAssuranceOrganization} the new QualityAssuranceOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Manufacturer enterprise
    */
    public QualityAssuranceOrganization createQualityAssuranceOrganization(String qaoName) throws Exception {
        if (this.company instanceof ManufacturerEnterprise) {
            QualityAssuranceOrganization newOrganization = new QualityAssuranceOrganization(qaoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Quality Assurance organization can only be created by Manufacturer enterprises.");
    }
    
    /**
    * Create a new LogisticsOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param loName the new organization's name
    * 
    * @return {@link LogisticsOrganization} the new LogisticsOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Supplier enterprise
    */
    public LogisticsOrganization createLogisticsOrganization(String loName) throws Exception {
        if (this.company instanceof SupplierEnterprise) {
            LogisticsOrganization newOrganization = new LogisticsOrganization(loName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Logistics organization can only be created by Supplier enterprises.");
    }
    
    /**
    * Create a new WarehousingOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param woName the new organization's name
    * 
    * @return {@link WarehousingOrganization} the new WarehousingOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Supplier enterprise
    */
    public WarehousingOrganization createWarehousingOrganization(String woName) throws Exception {
        if (this.company instanceof SupplierEnterprise) {
            WarehousingOrganization newOrganization = new WarehousingOrganization(woName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Warehousing organization can only be created by Supplier enterprises.");
    }
    
    /**
    * Create a new ServiceOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param servoName the new organization's name
    * 
    * @return {@link ServiceOrganization} the new ServiceOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Dealership enterprise
    */
    public ServiceOrganization createServiceOrganization(String servoName) throws Exception {
        if (this.company instanceof DealershipEnterprise) {
            ServiceOrganization newOrganization = new ServiceOrganization(servoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Service organization can only be created by Dealership enterprises.");
    }
    
    /**
    * Create a new SalesOrganization, add to internal list of organizations, then return organization for modification
    * 
    * @param saleoName the new organization's name
    * 
    * @return {@link SalesOrganization} the new SalesOrganization object created
    * 
    * @throws Exception If attempted to be instantiated for enterprise other than Dealership enterprise
    */
    public SalesOrganization createSalesOrganization(String saleoName) throws Exception {
        if (this.company instanceof DealershipEnterprise) {
            SalesOrganization newOrganization = new SalesOrganization(saleoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Sales organization can only be created by Dealership enterprises.");
    }
    
    /**
    * Remove specified organization from list of organizations
    * 
    * @param o reference to the organization to be deleted
    */
    public void removeOrganization(Organization o) {
        this.organizations.remove(o);
    }
}
