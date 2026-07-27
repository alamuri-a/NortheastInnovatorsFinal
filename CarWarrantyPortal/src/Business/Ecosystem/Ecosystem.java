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
    // Database masterDB
    
    // CONSTRUCTORS
    public Ecosystem(String n) {
        this.name = n;
        
        // DB initalization
        
        this.networks = new ArrayList(); // If networks in DB, use those
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
