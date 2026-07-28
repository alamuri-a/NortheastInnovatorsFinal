/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Ecosystem;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Ajay Alamuri
 */
public class Network {
    
    // ATTRIBUTES
    int id;
    String name;
    EnterpriseDirectory enterprises;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public Network(String n) {
        this.name = n;
        this.id = ++instances;
        this.enterprises = new EnterpriseDirectory();
    }
    
    // METHODS
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String n) {
        this.name = n;
    }

    public EnterpriseDirectory getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(EnterpriseDirectory enterprises) {
        this.enterprises = enterprises;
    }
    
    
}
