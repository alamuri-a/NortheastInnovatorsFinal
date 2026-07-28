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
    
    public Organization findOrganization(int oID) {
        for (Organization org : organizations) {
            if (org.getID() == oID) return org;
        }
        return null;
    }
    
    public ProductionOrganization createProductionOrganization(String poName) throws Exception {
        if (this.company instanceof ManufacturerEnterprise) {
            ProductionOrganization newOrganization = new ProductionOrganization(poName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Production organization can only be created by Manufacturer enterprises.");
    }
    
    public QualityAssuranceOrganization createQualityAssuranceOrganization(String qaoName) throws Exception {
        if (this.company instanceof ManufacturerEnterprise) {
            QualityAssuranceOrganization newOrganization = new QualityAssuranceOrganization(qaoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Quality Assurance organization can only be created by Manufacturer enterprises.");
    }
    
    public LogisticsOrganization createLogisticsOrganization(String loName) throws Exception {
        if (this.company instanceof SupplierEnterprise) {
            LogisticsOrganization newOrganization = new LogisticsOrganization(loName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Logistics organization can only be created by Supplier enterprises.");
    }
    
    public WarehousingOrganization createWarehousingOrganization(String woName) throws Exception {
        if (this.company instanceof SupplierEnterprise) {
            WarehousingOrganization newOrganization = new WarehousingOrganization(woName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Warehousing organization can only be created by Supplier enterprises.");
    }
    
    public ServiceOrganization createServiceOrganization(String servoName) throws Exception {
        if (this.company instanceof DealershipEnterprise) {
            ServiceOrganization newOrganization = new ServiceOrganization(servoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Service organization can only be created by Dealership enterprises.");
    }
    
    public SalesOrganization createSalesOrganization(String saleoName) throws Exception {
        if (this.company instanceof DealershipEnterprise) {
            SalesOrganization newOrganization = new SalesOrganization(saleoName, this.organizationCount++, this.company);
            this.organizations.add(newOrganization);
            return newOrganization;
        }
        throw new Exception("Sales organization can only be created by Dealership enterprises.");
    }
    
    public void removeOrganization(Organization o) {
        this.organizations.remove(o);
    }
}
