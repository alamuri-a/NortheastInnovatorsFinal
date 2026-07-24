/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

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
    
    public Enterprise CreateEnterprise(String eName) {
        Enterprise newEnterprise = new Enterprise(eName);
        this.enterprises.add(newEnterprise);
        return newEnterprise;
    }
    
    public void RemoveEnterprise(Enterprise e) {
        this.enterprises.remove(e);
    }
    
}
