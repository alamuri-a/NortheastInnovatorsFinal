/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;

/**
 *
 * @author Ajay Alamuri
 */
public abstract class WorkTask {
    
    // ATTRIBUTES
    int id;
    User assigner;
    User assignee;
    boolean completed;
    
    static int instances = 0;
    
    // CONSTRUCTORS
    public WorkTask(User aser) {
        this.id = ++instances;
        this.completed = false;
        this.assigner = aser;
    }
    
    // METHODS
    public int GetID() { return this.id; }
    
    public void Complete() {
        this.completed = true;
    }
}
