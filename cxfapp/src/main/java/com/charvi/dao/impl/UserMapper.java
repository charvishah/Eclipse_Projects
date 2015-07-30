package com.charvi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.charvi.domain.User;

@SuppressWarnings("rawtypes")
public class UserMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
       User user = new User();
       user.setId(rs.getString("ID"));
       user.setName(rs.getString("NAME"));
       user.setEmail(rs.getString("EMAIL"));
       return user;
    }

}
