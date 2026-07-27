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
    public Enterprise FindEnterprise(int eID) {
        for (Enterprise ent : enterprises) {
            if (ent.GetID() == eID) return ent;
        }
        return null;
    }
    
    public ManufacturerEnterprise CreateManufacturerEnterprise(String mfeName) {
        ManufacturerEnterprise newEnterprise = new ManufacturerEnterprise(mfeName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public SupplierEnterprise CreateSupplierEnterprise(String seName) {
        SupplierEnterprise newEnterprise = new SupplierEnterprise(seName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public DealershipEnterprise CreateDealershipEnterprise(String deName) {
        DealershipEnterprise newEnterprise = new DealershipEnterprise(deName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public void RemoveEnterprise(Enterprise e) {
        this.enterprises.remove(e);
    }
    
}
