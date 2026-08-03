/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkTaskQueue;

import Business.User.User;

/**
 *
 * @author Ajay Alamuri
 * @author Nicholas Woodward
 */
public class TradeInTask extends WorkTask {
    
    // ATTRIBUTES
    private int VIN;
    
    // CONSTRUCTORS
    public TradeInTask(User assigner, int vin) {
        super(assigner);
        this.VIN = vin;
    }
       /**
     * Returns the VIN of the vehicle offered for trade-in.
     *
     * @return trade-in vehicle identification number
     */
    public int getVIN() {
        return VIN;
    }

    /**
     * Returns a readable Service Center queue label.
     *
     * @return trade-in request description
     */
    @Override
    public String toString() {
        return "Trade-In Evaluation - VIN " + VIN;
    } 
}
