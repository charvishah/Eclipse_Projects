package com.charvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.charvi.domain.User;
import com.charvi.util.DBConnection;


public interface UserDao {
        
    public User getUserById(String id);

}