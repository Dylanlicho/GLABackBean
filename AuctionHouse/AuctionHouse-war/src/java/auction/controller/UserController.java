/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.controller;

import auction.dto.LoginDTO;
import auction.dto.UserDTO;
import auction.entities.UserEntity;
import auction.services.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author attuku
 */

@Path("")
public class UserController {

    @EJB
    UserService userService;
    
    @DELETE
    @Path("user/{id}")
    @Consumes()
    public void deleteUser(@PathParam("id") int id){
        userService.deleteUser(id);
    }
    
    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getUser(@PathParam("id") int id){
        return userService.getUser(id);
    }

    @GET
    @Path("user/login/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getUserByLogin(@PathParam("login") String login){
        return userService.getUserByLogin(login);
    }
    
    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }
    
    @POST
    @Path("auth/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity register(UserDTO userDTO) {
        return userService.register(userDTO);
    }
    
    @POST
    @Path("auth/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity verify(LoginDTO loginDTO) {
        return userService.verify(loginDTO);
    }
}
