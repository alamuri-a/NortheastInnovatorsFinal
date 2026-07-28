/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class EnterpriseDirectory {
    
    // ATTRIBUTES
    ArrayList<Enterprise> enterprises;
    
    // CONSTRUCTORS
    public EnterpriseDirectory() {
        this.enterprises = new ArrayList();
    }
    
    // METHODS
    /**
    * Gets enterprise with matching ID or returns NULL if no enterprise found with matching ID
    * 
    * @param eID the enterprise ID
    * 
    * @return {@link Enterprise} or NULL
    */
    public Enterprise findEnterprise(int eID) {
        for (Enterprise ent : enterprises) {
            if (ent.getID() == eID) return ent;
        }
        return null;
    }
    
    /**
    * Create a new ManufacturerEnterprise, add to internal list of enterprises, then return enterprise for modification
    * 
    * @param mfeName the new manufacturer's name
    * 
    * @return {@link ManufacturerEnterprise} the new ManufacturerEnterprise object created
    */
    public ManufacturerEnterprise createManufacturerEnterprise(String mfeName) {
        ManufacturerEnterprise newEnterprise = new ManufacturerEnterprise(mfeName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    /**
    * Create a new SupplierEnterprise, add to internal list of enterprises, then return enterprise for modification
    * 
    * @param seName the new manufacturer's name
    * 
    * @return {@link SupplierEnterprise} the new SupplierEnterprise object created
    */
    public SupplierEnterprise createSupplierEnterprise(String seName) {
        SupplierEnterprise newEnterprise = new SupplierEnterprise(seName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    /**
    * Create a new DealershipEnterprise, add to internal list of enterprises, then return enterprise for modification
    * 
    * @param deName the new manufacturer's name
    * 
    * @return {@link DealershipEnterprise} the new DealershipEnterprise object created
    */
    public DealershipEnterprise createDealershipEnterprise(String deName) {
        DealershipEnterprise newEnterprise = new DealershipEnterprise(deName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    /**
    * Remove specified enterprise from list of enterprise
    * 
    * @param e reference to the enterprise to be deleted
    */
    public void removeEnterprise(Enterprise e) {
        this.enterprises.remove(e);
    }

    public ArrayList<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(ArrayList<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }
    
}
