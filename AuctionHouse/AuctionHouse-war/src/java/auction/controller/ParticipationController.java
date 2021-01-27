/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.controller;

import auction.dto.ParticipationDTO;
import auction.entities.ArticleEntity;
import auction.entities.ParticipationEntity;
import auction.services.ParticipationService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author attuku
 */
@Path("")
public class ParticipationController {
    @EJB
    ParticipationService participationService;
    
    @GET
    @Path("participation/best/{idArticle}")
    @Produces(MediaType.APPLICATION_JSON)
    public ParticipationEntity bestParticipationByIdArticle(@PathParam("idArticle") int idArticle){
        return participationService.bestParticipationByIdArticle(idArticle);
    }

    @GET
    @Path("participation/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArticleEntity> ParticipationByIdUser(@PathParam("id") int idUser){
        return participationService.ParticipationByIdUser(idUser);
    }
    
    @POST
    @Path("addParticipation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ParticipationEntity createParticipation(ParticipationDTO participationDTO){
        return participationService.createParticipation(participationDTO);
    }
    
    @PUT
    @Path("updateParticipation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ParticipationEntity updateParticipation(ParticipationDTO participationDTO){
        return participationService.updateParticipation(participationDTO);
    }
}
