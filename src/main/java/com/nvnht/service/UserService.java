/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service;

import com.nvnht.pojo.User;
import com.nvnht.pojo.UserDetail;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author nghia
 */
public interface UserService extends UserDetailsService {

    boolean addUserCustomer(User user, UserDetail userDetail);

    List<User> getUsers(String username);
    
    User findUserByUsername(String username);
}
