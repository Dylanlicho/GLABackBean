/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.ArticleDTO;
import java.util.Date;
import java.util.Set;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author attuku
 */
@Entity
@NamedQuery(name= "ArticleEntity.getAll", 
            query="SELECT art FROM ArticleEntity art")
@NamedQuery(name= "ArticleEntity.deleteOne", 
            query="DELETE FROM ArticleEntity art WHERE art.id = ?1")
@NamedQuery(name="ArticleEntity.getBySeller", 
            query="SELECT art FROM ArticleEntity art Where art.seller = ?1")
@Table(name="articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne
    //@JoinColumn(name="seller")
    private int seller;

    private String name;
    private String description;
    private double startPrice;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbDateFormat(value="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbDateFormat(value="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private double weight;

    @ManyToMany // Article * --- * Category
    Set<CategoryEntity> categories;
    
    @OneToOne(mappedBy="article", fetch = FetchType.LAZY)
    PromotionEntity promotion;
    
    @OneToMany(mappedBy="article")
    Set<ParticipationEntity> participants;
    
    public ArticleEntity(){}
    
    public ArticleEntity(ArticleDTO articleDTO){
        this.name = articleDTO.getName();
        this.description = articleDTO.getDescription();
        this.startPrice = articleDTO.getStartPrice();
        this.startDate = articleDTO.getStartDate();
        this.endDate = articleDTO.getEndDate();
        this.weight = articleDTO.getWeight();
        this.seller = articleDTO.getSeller();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
