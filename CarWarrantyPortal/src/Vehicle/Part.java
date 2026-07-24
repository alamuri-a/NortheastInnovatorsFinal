/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehicle;

/**
 *
 * @author Ajay Alamuri
 */
public class Part {
    
    // ATTRIBUTES
    int id;
    boolean working;
    
    // CONSTRUCTORS
    public Part(int ID) {
        this.id = ID;
        this.working = Math.random() < 0.5;
    }
}
