/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.People;

/**
 *
 * @author Ajay Alamuri
 */
public class Employee {
    
    // ATTRIBUTES
    int id;
    Person person;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public Employee(Person pers) {
        this.id = ++instances;
        this.person = pers;
    }
    
    // METHODS
    public int getID() { return this.id; }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
