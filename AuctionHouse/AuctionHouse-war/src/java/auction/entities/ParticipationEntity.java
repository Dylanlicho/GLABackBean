/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.ParticipationDTO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author attuku
 */
@Entity
@Table(name="participation")
public class ParticipationEntity {
    
    @Id
    int id;
    
    private double price;

    int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    int idArticle;
    
    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name="idUser", updatable = false, insertable = false)
    private UserEntity user;

    @ManyToOne
    @MapsId("idArticle")
    @JoinColumn(name="idArticle", updatable = false, insertable = false)
    private ArticleEntity article;

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }
    

    
    public ParticipationEntity(){}
    
    public ParticipationEntity(ParticipationDTO participationDTO){
        this.idArticle = participationDTO.getIdArticle();
        this.idUser = participationDTO.getIdUser();
        this.price = participationDTO.getPrice();
    }
    
    
    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
