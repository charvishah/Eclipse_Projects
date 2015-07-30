package com.charvi.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.charvi.dao.UserDao;
import com.charvi.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SuppressWarnings({ "unchecked" })
    public User getUserById(String id) {
        String sql = "Select * from User where ID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        User user = (User) jdbcTemplate.queryForObject(
                                sql, new Object[] { id }, new UserMapper());

        return user;
    }
}

/*
 * try { con = dbConn.getDBConnection(); String sql =
 * "SELECT user_id, user_name, user_email FROM  USER where user_id = ? "; stmt =
 * con.prepareStatement(sql); // connection gives us any kind of stmnt. here it
 * is prep stmnt stmt.setString(1, id); // sets the user name dynamically at the
 * first ? sign
 * 
 * ResultSet res = stmt.executeQuery(); while (res.next()) {
 * user.setId(res.getString("USER_ID"));
 * user.setName(res.getString("USER_NAME"));
 * user.setEmail(res.getString("USER_EMAIL")); }
 * 
 * dbConn.closeConnection(); } catch (Exception ex) { ex.printStackTrace(); }
 */
