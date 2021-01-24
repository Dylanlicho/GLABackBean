/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dao.CategoryDAO;
import auction.dto.OfCategoryDTO;
import auction.entities.CategoryEntity;
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
public class CategoryService {
    @EJB
    CategoryDAO categoryDAO;
    
    public List<CategoryEntity> getAll(){
        return categoryDAO.getAll();
    }

    public void addOfCategory(OfCategoryDTO ofCategoryDTO) {
        categoryDAO.addOfCategory(ofCategoryDTO);
    }
}
