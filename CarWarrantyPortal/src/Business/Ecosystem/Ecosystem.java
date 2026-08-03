/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Ecosystem;

import Business.User.UserDirectory;
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class Ecosystem {
    
    // ATTRIBUTES
    private String name;
    private ArrayList<Network> networks;
    private UserDirectory superAdmins;
    private static Ecosystem business;// Database masterDB
    // Database masterDB
    
    // CONSTRUCTORS
    // * Required by db4o to reconstruct objects from the database. 
    public Ecosystem() {
        this.name = "Auto Ecosystem";
        this.networks = new ArrayList();
        this.superAdmins = new UserDirectory();
    }
    
    /**
    * Custom Constructor (Keep this for manual naming)
    */
    public Ecosystem(String n) {
        this.name = n;
        this.networks = new ArrayList();
        this.superAdmins = new UserDirectory();
    }

    public static Ecosystem getInstance(){
        if(business == null){
            business = new Ecosystem();
        }
        return business;
    }
    // METHODS
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Network> getNetworks() {
        return networks;
    }
    
    public void setNetworks(ArrayList<Network> networks) {
        this.networks = networks;
    }

    public UserDirectory getSuperAdmins() {
        return superAdmins;
    }

    public void setSuperAdmins(UserDirectory superAdmins) {
        this.superAdmins = superAdmins;
    }
    
    /**
    * Gets network with matching ID or returns NULL if no network found with matching ID
    * 
    * @param nID the network ID
    * 
    * @return {@link Network} or NULL
    */
    public Network findNetwork(int nID) {
        // Return network with matchin ID or null if no Network with ID is found
        
        for (Network net : networks) {
            if (net.getID() == nID) return net;
        }
        return null;
    }
    
    /**
    * Create a new network, add to internal list of networks, then return network for modification
    * 
    * @param nName the new network's name
    * 
    * @return {@link Network} the new Network object created
    */
    public Network createNetwork(String nName) {
        Network newNetwork = new Network(nName);
        this.networks.add(newNetwork);
        return newNetwork;
    }
    
    /**
    * Remove specified network from list of networks
    * 
    * @param net reference to the network to be deleted
    */
    public void deleteNetwork(Network net) {
        this.networks.remove(net);
    }
    
}
