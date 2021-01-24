/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dao.ArticleDAO;
import auction.entities.PromotionEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author attuku
 */
@Singleton
@Startup
public class PromotionService {
    @EJB
    private ArticleDAO articleDAO;
    
    @PersistenceContext(unitName="UserPU")
    EntityManager em;

    
    private List<PromotionEntity> promotion;
    
    @PostConstruct
    public void init(){
        promotion = articleDAO.getArticleInPromotion();
    }
    
    public List<PromotionEntity> getPromotions(){
         return promotion;
    }
    
   @Schedule(second="0", minute="0", hour="0")
   public void updatePromotion() {
       init();
    }
}
