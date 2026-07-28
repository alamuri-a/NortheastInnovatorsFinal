/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Ecosystem;

import Business.Enterprise.Enterprise;
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
    public String getName() { return this.name; }
    
    public ArrayList<Network> getNetworks() { return networks; }

    public void setNetworks(ArrayList<Network> networks) { this.networks = networks; }
    
    public Network findNetwork(int nID) {
        for (Network net : networks) {
            if (net.getID() == nID) return net;
        }
        return null;
    }
    
    public Network createNetwork(String nName) {
        Network newNetwork = new Network(nName);
        this.networks.add(newNetwork);
        return newNetwork;
    }
    
    public void deleteNetwork(Network net) {
        this.networks.remove(net);
    }
    
}
