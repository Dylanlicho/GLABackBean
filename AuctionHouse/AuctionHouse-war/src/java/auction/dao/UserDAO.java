/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.dto.UserDTO;
import auction.entities.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class UserDAO {
    @PersistenceContext(unitName="UserPU")
    EntityManager em;
    
    public UserEntity addUser(UserDTO u) {
        UserEntity ue = getUserByLogin(u.getLogin());
        if (ue == null){
            ue = new UserEntity(u);
            em.persist(ue);
        }
        return ue;
    }

    public UserEntity getUser(int id) {
        UserEntity v = em.find(UserEntity.class, id);
        return v;
    }
    
    public List<UserEntity> getAllUser(){
        Query query = em.createNamedQuery("UserEntity.getAll");
        return query.getResultList();
    }

    public int deleteUser(int id){
       Query query = em.createNamedQuery("UserEntity.deleteOne");
       query.setParameter(1, id);
       return query.executeUpdate();
    }

    public UserEntity getUserByLogin(String login) {
        UserEntity v = null;
        TypedQuery<UserEntity> query = em.createQuery("SELECT ue FROM UserEntity ue Where ue.login = '"+login+"' ", UserEntity.class);
        if (query.getResultList().size() > 0)
            v = query.getSingleResult();
        return v;
    }
}
