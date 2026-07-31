/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
 */
public class ManufacturerEnterprise extends Enterprise {
    
    // ATTRIBUTES
      private Type enterpriseType;
    //Orders recieved for new parts and vehicles including custom orders

    //Quality Assurance records and shipments to dealers and parts supplier

    //Recall records

    // Database partsDB
    // Database shipments;
    
    // CONSTRUCTORS
    public ManufacturerEnterprise(String name) {
        super(name);

    }
       @Override
    public Type getEnterpriseType() {
        return Type.Manu; // Hardcoded return for this subclass
    }
}
