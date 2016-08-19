/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dmdcapstone.dao;

import com.mycompany.dmdcapstone.model.User;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface UserDao {

    public User addUser(User newUser);

    public void deleteUser(String username);
    
    public List<User> getAllUsers();
}
