package com.charvi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charvi.dao.UserDao;
import com.charvi.domain.User;
import com.charvi.service.UserService;


@Path("/users")
public class UserResource {
    
    //@Autowired
    UserService userService;
    
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") String id) {
	    return userService.getUser(id);
	}

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
