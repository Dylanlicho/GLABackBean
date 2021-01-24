/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.ParticipationDTO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author attuku
 */
@Entity
@Table(name="participation")
public class ParticipationEntity {
    @Id
    private int idUser;
    @Id
    private int idArticle;
    private double price;

    public ParticipationEntity(){}
    
    public ParticipationEntity(ParticipationDTO participationDTO){
        this.idArticle = participationDTO.getIdArticle();
        this.idUser = participationDTO.getIdUser();
        this.price = participationDTO.getPrice();
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
