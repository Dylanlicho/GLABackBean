/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dao.ArticleDAO;
import auction.dto.ArticleDTO;
import auction.entities.ArticleEntity;
import auction.entities.PromotionEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class ArticleService {

    @EJB
    ArticleDAO articleDAO;
    
    public List<ArticleEntity> getAllArticle() {
        return articleDAO.getAllArticle();
    }

    public ArticleEntity getArticleById(int articleId) {
        return articleDAO.getArticleById(articleId);
    }

    public int deleteArticleById(int articleId) {
        return articleDAO.deleteArticleById(articleId);
    }

    public List<ArticleEntity> getArticlesBySeller(int sellerId) {
        return articleDAO.getArticlesBySeller(sellerId);
    }

    public ArticleEntity addArticle(ArticleDTO articleDTO) {
        return articleDAO.addArticle(articleDTO);
    }

    public List<ArticleEntity> getArticleByName(String name) {
        return articleDAO.getArticleByName(name);
    }

    public List<ArticleEntity> getArticleByCategoryId(int id) {
        return articleDAO.getArticleByCategoryId(id);
    }

    public List<PromotionEntity> getArticleInPromotion() {
        return articleDAO.getArticleInPromotion();
    }
    
}
