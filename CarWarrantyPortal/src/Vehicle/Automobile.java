/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehicle;

import People.Person;
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
    public int GetVIN() { return this.VIN; }
    
    public Person GetOwner() { return this.owner; }
}
