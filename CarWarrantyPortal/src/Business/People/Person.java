/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.People;

/**
 *
 * @author Ajay Alamuri
 */
public class Person {
    
    // ATTRIBUTES
    String name;
    
    // CONSTRUCTORS
    public Person(String n) {
        this.name = n;
    }
    
    // METHODS
    public String getName() { return this.name; }
    
    public void setName(String n) { this.name = n; }
}
