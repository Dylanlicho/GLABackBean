/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.dto.OfCategoryDTO;
import auction.entities.CategoryEntity;
import auction.entities.OfCategoryEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class CategoryDAO {
    @PersistenceContext(unitName="UserPU")
    EntityManager em;
    
    public List<CategoryEntity> getAll() {
        Query query = em.createNamedQuery("CategoryEntity.getAll");
        return query.getResultList();
    }

    public void addOfCategory(OfCategoryDTO ofCategoryDTO) {
        OfCategoryEntity oce = new OfCategoryEntity(ofCategoryDTO);
        em.persist(oce);
    }
}
