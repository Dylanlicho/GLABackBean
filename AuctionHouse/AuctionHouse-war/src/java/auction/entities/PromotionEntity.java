/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author attuku
 */
@Entity
@NamedQuery(name= "PromotionEntity.getAll", 
            query="SELECT promo FROM PromotionEntity promo")
@Table(name="promotions")
public class PromotionEntity {
   @Id
   int idArticle;
   int reduction;
   
   @OneToOne
   @JoinColumn(name= "idArticle", referencedColumnName="id", updatable = false, insertable = false)
   ArticleEntity article;
   
   public PromotionEntity(){}
   
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

}
