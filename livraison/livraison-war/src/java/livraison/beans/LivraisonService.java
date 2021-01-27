/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraison.beans;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import livraison.dto.OrderDTO;
import livraison.entity.OrderEntity;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class LivraisonService {
    @PersistenceContext(unitName="LivraisonPU")
    EntityManager em;

    void add(OrderDTO order) {
        OrderEntity oe = new OrderEntity(order);
        em.persist(oe);
    }

    public List<OrderEntity> getAll() {
        Query query = em.createNamedQuery("OrderEntity.getAll");
        return query.getResultList();
    }
    
}
