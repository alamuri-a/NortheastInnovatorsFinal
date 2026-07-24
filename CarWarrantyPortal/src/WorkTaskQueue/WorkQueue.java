/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkTaskQueue;

import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class WorkQueue {
    
    // ATTRIBUTES
    ArrayList<WorkTask> tasks;
    
    // CONSTRUCTORS
    public WorkQueue() {
        this.tasks = new ArrayList();
    }
    
    // METHODS
    public WorkTask GetTask(int tID) {
        for (WorkTask task : tasks) {
            if (task.GetID() == tID) return task;
        }
        return null;
    }
    
    public WorkTask AddTask() {
        WorkTask newTask = new WorkTask();
        this.tasks.add(newTask);
        return newTask;
    }
}
