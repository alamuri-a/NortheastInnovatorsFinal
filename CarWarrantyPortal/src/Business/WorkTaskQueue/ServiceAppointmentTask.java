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
public class ServiceAppointmentTask extends WorkTask {
    
    // ATTRIBUTES
    private int VIN;
    
    // CONSTRUCTORS
    public ServiceAppointmentTask(User assigner, int vin) {
        super(assigner);
        this.VIN = vin;
    }
    /**
     * Returns the VIN of the vehicle scheduled for service.
     *
     * @return vehicle identification number
     */
    public int getVIN() {
        return VIN;
    }

    /**
     * Returns a readable appointment label for service-center work queues.
     *
     * @return appointment description containing the vehicle VIN
     */
    @Override
    public String toString() {
        return "Service Appointment - VIN " + VIN;
    }
}
