/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.User;

import Business.People.Employee;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajay Alamuri
 */
public class UserDirectory {
    
    // ATTRIBUTES
    private ArrayList<User> users;
    
    // CONSTRUCTORS
    public UserDirectory() {
        this.users = new ArrayList();
    }
    
    // METHODS
    /**
    * Gets user with matching ID or returns NULL if no user found with matching ID
    * 
    * @param uID the user ID
    * 
    * @return {@link User} or NULL
    */
    public User findUser(int uID) {
        for (User usr : users) {
            if (usr.getID() == uID) return usr;
        }
        return null;
    }
    
    /**
    * Create a new User, add to internal list of users, then return user for modification
    * 
    * @param emp Employee object that user account is attached to
    * @param username String username for account login
    * @param password String password for account login
    * @param role Role handling authorization for user account
    * 
    * @return {@link User} the new User object created
    */
    public User createUser(Employee emp, String username, String password, Role role) {
        User newUser = new User(emp, username, password, role);
        this.users.add(newUser);
        return newUser;
    }
    
    /**
    * Remove specified user from list of user
    * 
    * @param u reference to the user to be deleted
    */
    public void removeUser(User u) {
        this.users.remove(u);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
