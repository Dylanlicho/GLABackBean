/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.controller;

import auction.dto.OfCategoryDTO;
import auction.entities.CategoryEntity;
import auction.services.CategoryService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author attuku
 */
@Path("")
public class CategoryController {
    
    @EJB
    CategoryService categoryService;
    
    @GET
    @Path("categories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryEntity> getAll(){
       return categoryService.getAll();
    }

    @POST
    @Path("addOfCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addOfCategory(OfCategoryDTO ofCategoryDTO){
       categoryService.addOfCategory(ofCategoryDTO);
       return 0;
    }
}
