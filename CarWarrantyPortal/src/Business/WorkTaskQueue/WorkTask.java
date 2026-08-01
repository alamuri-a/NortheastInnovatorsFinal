/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;

/**
 *
 * @author Ajay Alamuri
 * @author Meredith Molyneux
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
        this.assignee = null;
        
        aser.incrementTasksCreated();
    }
    
    // METHODS
    public int getID() {
        return this.id;
    }

    public User getAssigner() {
        return assigner;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public boolean isCompleted() {
        return completed;
    }
    
    public void Complete() {
        this.completed = true;
    }
 @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
