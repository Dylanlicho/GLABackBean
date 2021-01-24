/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.controller;

import auction.dto.ArticleDTO;
import auction.entities.ArticleEntity;
import auction.entities.PromotionEntity;
import auction.services.ArticleService;
import auction.services.PromotionService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author attuku
 */
@Path("")
public class ArticleController {
    @EJB
    ArticleService articleService;
    
    @EJB
    PromotionService promotionService;
    
    @GET
    @Path("articles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArticleEntity> getAllArticle(){
        return articleService.getAllArticle();
    }
    
    @GET
    @Path("article/seller/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArticleEntity> getArticlesBySeller(@PathParam("userID") int id){
        return articleService.getArticlesBySeller(id);
    }
    
    @GET
    @Path("article/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArticleEntity> getArticleById(@PathParam("name") String name){
        return articleService.getArticleByName(name); 
    }
    
    @GET
    @Path("article/category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ArticleEntity> getArticleByCategoryId(@PathParam("id") int id){
        return articleService.getArticleByCategoryId(id); 
    }
    
    
    @GET
    @Path("article/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArticleEntity getArticleById(@PathParam("id") int articleId){
        return articleService.getArticleById(articleId); 
    }
    
    @GET
    @Path("article/promotions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PromotionEntity> getArticleInPromotion(){
        return promotionService.getPromotions(); 
    }
    
    @POST
    @Path("/addArticle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArticleEntity addArticle(ArticleDTO articleDTO){
        return articleService.addArticle(articleDTO);
    }
    
    @DELETE
    @Path("deleteArticleById/{id}")
    public int deleteArticleById(@PathParam("id") int articleId){
        return articleService.deleteArticleById(articleId); 
    }
}
