/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Vehicle;

import Business.People.Person;
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class Automobile {
    
    // ATTRIBUTES
    int VIN;
    String make;
    String model;
    ArrayList<Part> parts;
    Person owner;
    
    // CONSTRUCTOR
    public Automobile(int vin, String mk, String mdl, Person own) {
        this.VIN = vin;
        this.make = mk;
        this.model = mdl;
        this.parts = new ArrayList();
        this.owner = own;
    }
    
    // METHODS
    public int getVIN() {
        return this.VIN;
    }
    
    public Person getOwner() {
        return this.owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
    
    /**
    * Remove specified enterprise from list of enterprise
    * 
    * @return array list of @{link Part} from automobile which are broken
    */
    public ArrayList<Part> Diagnose() {
        ArrayList<Part> brokenParts = new ArrayList();
        for (Part p : parts) {
            if (!p.isWorking()) brokenParts.add(p);
        }
        return brokenParts;
    }
}
