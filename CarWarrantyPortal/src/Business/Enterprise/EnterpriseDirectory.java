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
    public Enterprise createEnterprise(String name, Enterprise.Type type) {
        Enterprise enterprise = null;

        // 1. Dynamic check against the Enum type
        if (type.equals(Enterprise.Type.Manu)) {
            enterprise = new ManufacturerEnterprise(name);
        }
        else if (type.equals(Enterprise.Type.Dealer)) {
            enterprise = new DealershipEnterprise(name);
        }
        else if (type.equals(Enterprise.Type.Supplier)) {
            enterprise = new SupplierEnterprise(name);
        }

        // 2. Cache it inside the directory list if valid
        if (enterprise != null) {
            enterprises.add(enterprise);
        }

        return enterprise;
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
    
    public ArrayList<DealershipEnterprise> getDealerships() {
        ArrayList<DealershipEnterprise> dealers = new ArrayList();
        for (Enterprise e : this.enterprises) {
            if (e instanceof DealershipEnterprise dealer) dealers.add(dealer);
        }
        return dealers;
    }
    
    public ArrayList<SupplierEnterprise> getSuppliers() {
        ArrayList<SupplierEnterprise> suppliers = new ArrayList();
        for (Enterprise e : this.enterprises) {
            if (e instanceof SupplierEnterprise supplier) suppliers.add(supplier);
        }
        return suppliers;
    }
    
    public ArrayList<ManufacturerEnterprise> getManufacturers() {
        ArrayList<ManufacturerEnterprise> manufacturers = new ArrayList();
        for (Enterprise e : this.enterprises) {
            if (e instanceof ManufacturerEnterprise manufacturer) manufacturers.add(manufacturer);
        }
        return manufacturers;
    }
    
}
