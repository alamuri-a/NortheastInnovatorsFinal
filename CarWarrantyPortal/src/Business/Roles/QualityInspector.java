/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.WorkTaskQueue.WorkTask;
import UserInterface.WorkAreas.QualityInspectorWorkAreaJPanel;

/**
 *
 * @author Ajay Alamuri
 */
public class QualityInspector extends Role {
    
    // ATTRIBUTES
    WorkTask currentTask;
    
    // CONSTRUCTOR
    public QualityInspector() {
        super(new QualityInspectorWorkAreaJPanel());
    }
    
    // METHODS
    @Override
    public String toString() {
        return "Quality Inspector";
    }
    
    @Override
    public void LoadWorkArea() {
        // TODO
    }
}
