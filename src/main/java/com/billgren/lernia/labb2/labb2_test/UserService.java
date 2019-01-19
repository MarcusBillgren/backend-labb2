package com.billgren.lernia.labb2.labb2_test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
	UserDao userDao = new UserDao();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.getAllUsers();
	}
	
	@POST
	@Path("/submit")
	@Produces(MediaType.APPLICATION_XML)
	public void submitUsers(List<User> users) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		userDao.addAllUsers(users);
	}
	
//Kommando för att lägga till post
//curl -H "Content-Type: text/xml" -d '<users><user><name>Bengtina Ballerina</name><profession>Ballerina</profession></user></users>' http://localhost:8080/backend-labb2/UserService/submit
}
