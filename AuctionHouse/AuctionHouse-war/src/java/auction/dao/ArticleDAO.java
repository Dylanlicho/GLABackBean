/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.dto.ArticleDTO;
import auction.entities.ArticleEntity;
import auction.entities.PromotionEntity;
import auction.entities.UserEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class ArticleDAO {
    @PersistenceContext(unitName="AuctionPU")
    EntityManager em;
    
    public List<ArticleEntity> getAllArticle() {
        Query query = em.createNamedQuery("ArticleEntity.getAll");
        return query.getResultList();
    }

    public ArticleEntity getArticleById(int articleId) {
        return em.find(ArticleEntity.class, articleId);
    }

    public int deleteArticleById(int articleId) {
       Query query = em.createNamedQuery("ArticleEntity.deleteOne");
       query.setParameter(1, articleId);
       return query.executeUpdate();
    }

    public List<ArticleEntity> getArticlesBySeller(int sellerId) {
        Query query = em.createNamedQuery("ArticleEntity.getBySeller");
        query.setParameter(1, sellerId);
        return query.getResultList();
    }

    public ArticleEntity addArticle(ArticleDTO articleDTO) {
        ArticleEntity ret = new ArticleEntity(articleDTO);
        em.persist(ret);
        return ret;   
    }

    public List<ArticleEntity> getArticleByName(String name) {
        TypedQuery<ArticleEntity> query = em.createQuery("SELECT art "
                                             + "FROM ArticleEntity art "
                                             + "Where art.name Like '"+name+"%'", ArticleEntity.class);

        return query.getResultList();
    }
    
    public List<ArticleEntity> getArticleByCategoryId(int id){
        List<ArticleEntity> ret = null;
        TypedQuery<ArticleEntity> query = em.createQuery("SELECT cae.articles "
                                             + "FROM CategoryEntity cae "
                                             + "Where cae.id = "+id, ArticleEntity.class);        
        if (query.getResultList().size() > 0)
            ret = query.getResultList();
        return ret;
    }

    public List<PromotionEntity> getArticleInPromotion() {
        Query query = em.createNamedQuery("PromotionEntity.getAll");
        return query.getResultList();
    }
}
