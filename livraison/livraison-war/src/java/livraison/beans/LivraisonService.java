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
import javax.persistence.TypedQuery;
import livraison.entity.OrderEntity;
import serializable.OrderDTO;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class LivraisonService {
    @PersistenceContext(unitName="DeliveryPU")
    EntityManager em;

    public void add(OrderDTO order) {
        TypedQuery<OrderEntity> query = em.createQuery("SELECT oe FROM OrderEntity oe"
                                             + " WHERE oe.idArticle = "+order.getIdArticle(), OrderEntity.class);
        if (query.getResultList().size() > 0)
            return;
        OrderEntity oe = new OrderEntity(order);
        em.persist(oe);
    }

    public List<OrderEntity> getAll() {
        Query query = em.createNamedQuery("OrderEntity.getAll");
        return query.getResultList();
    }

    public List<OrderEntity> getAllOrderOf(int buyer) {
        TypedQuery<OrderEntity> query = em.createQuery("SELECT oe FROM OrderEntity oe"
                                                     + " WHERE oe.buyer = "+buyer, OrderEntity.class);
        return query.getResultList();
    }
    
}
