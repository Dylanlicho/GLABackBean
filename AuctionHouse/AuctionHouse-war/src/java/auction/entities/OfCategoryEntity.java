/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.OfCategoryDTO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author attuku
 */
@Entity
@Table(name="of_category")
public class OfCategoryEntity {
    @Id
    int idArticle;
    @Id
    int idCategory;
    
    public OfCategoryEntity(){}
    
    public OfCategoryEntity(OfCategoryDTO ofCategoryDTO) {
        this.idArticle = ofCategoryDTO.getIdArticle();
        this.idCategory = ofCategoryDTO.getIdCategory();
    }
    
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
