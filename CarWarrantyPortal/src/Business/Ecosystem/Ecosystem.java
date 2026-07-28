/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Ecosystem;

import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class Ecosystem {
    
    // ATTRIBUTES
    String name;
    ArrayList<Network> networks;
    private static Ecosystem business;// Database masterDB
   
        
    // CONSTRUCTORS

        // * Required by db4o to reconstruct objects from the database.
     
    public Ecosystem() {
        this.name = "Auto Ecosystem";
        this.networks = new ArrayList();
        
        }
     /**
     * Custom Constructor (Keep this for manual naming)
     */
     public Ecosystem(String n) {
        this.name = n;
        this.networks = new ArrayList();
     }

    public static Ecosystem getInstance(){
        if(business == null){
            business = new Ecosystem();
        }
        return business;
    }
    // METHODS
    public String GetName() { return this.name; }
    
    public Network FindNetwork(int nID) {
        for (Network net : networks) {
            if (net.GetID() == nID) return net;
        }
        return null;
    }
    
    public Network CreateNetwork(String nName) {
        Network newNetwork = new Network(nName);
        this.networks.add(newNetwork);
        return newNetwork;
    }
    
    public void DeleteNetwork(Network net) {
        this.networks.remove(net);
    }
    
}
