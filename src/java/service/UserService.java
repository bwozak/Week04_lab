/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;


/**
 *
 * @author 672762
 */
public class UserService {
    
    //for storing user data
    ArrayList<User> user = new ArrayList<>();
    
    /**
     * Constructor method for a user object
     */
    public UserService() {
	user.add(new User("adam", "password"));
	user.add(new User("betty", "password"));
    }
    
    /**
     * This method handles User Login
     * @param username
     * @param password
     * @return 
     */
    public User login(String username, String password) {
	for(User user : user) {
	    if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
		return new User(username);
	    }
	}
	return null;
    }
}
