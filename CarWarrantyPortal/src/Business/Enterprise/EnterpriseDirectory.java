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
    public Enterprise findEnterprise(int eID) {
        for (Enterprise ent : enterprises) {
            if (ent.getID() == eID) return ent;
        }
        return null;
    }
    
    public ManufacturerEnterprise createManufacturerEnterprise(String mfeName) {
        ManufacturerEnterprise newEnterprise = new ManufacturerEnterprise(mfeName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public SupplierEnterprise createSupplierEnterprise(String seName) {
        SupplierEnterprise newEnterprise = new SupplierEnterprise(seName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public DealershipEnterprise createDealershipEnterprise(String deName) {
        DealershipEnterprise newEnterprise = new DealershipEnterprise(deName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
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
