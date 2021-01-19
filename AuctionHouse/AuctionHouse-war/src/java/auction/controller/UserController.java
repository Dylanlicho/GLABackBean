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
@Path("user")
public class UserController {

    @EJB
    UserService userService;
    
    @DELETE
    @Path("{id}")
    @Consumes()
    public void deleteUser(@PathParam("id") int id){
        userService.deleteUser(id);
    }
    
    @GET
    @Path("{login}")
    @Consumes()
    public UserEntity getUser(@PathParam("login") String login){
        return userService.getUserByLogin(login);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity register(UserDTO userDTO) {
        return userService.register(userDTO);
    }
    
    @POST
    @Path("verify")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity verify(LoginDTO loginDTO) {
        return userService.verify(loginDTO);
    }
}
