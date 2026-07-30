/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Vehicle.Part;
import java.util.HashMap;

/**
 *
 * @author Ajay Alamuri
 */
public class SupplierEnterprise extends Enterprise {
    
    // ATTRIBUTES
    HashMap<Part, Integer> partsStock;
    
    // CONSTRUCTORS
    public SupplierEnterprise(String n) {
        super(n);
        this.partsStock = new HashMap();
    }
    
    // METHODS
    public int getPartQuantity(Part part) {
        Integer quantity = this.partsStock.get(part);
        return (quantity == null) ? 0 : (int) quantity;
    }
    
    public void setPartQuantity(Part part, int newQuantity) {
        this.partsStock.put(part, newQuantity);
    }
    
}
