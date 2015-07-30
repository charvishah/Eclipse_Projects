/**
 * 
 */
package com.charvi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charvi.dao.UserDao;
import com.charvi.domain.User;
import com.charvi.service.UserService;

//@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userdao;

    public User getUser(String userId) {
        User userFromRecords =  userdao.getUserById(userId);
        return userFromRecords;
    }

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }
    
    

}
