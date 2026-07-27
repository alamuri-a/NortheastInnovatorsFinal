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
    ArrayList<User> users;
    
    // CONSTRUCTORS
    public UserDirectory() {
        this.users = new ArrayList();
    }
    
    // METHODS
    public User FindUser(int uID) {
        for (User usr : users) {
            if (usr.GetID() == uID) return usr;
        }
        return null;
    }
    
    public User CreateUser(Employee emp, String username, String password, Role role) {
        User newUser = new User(emp, username, password, role);
        this.users.add(newUser);
        return newUser;
    }
    
    public void RemoveUser(User u) {
        this.users.remove(u);
    }
}
