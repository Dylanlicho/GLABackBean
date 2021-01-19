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
        UserEntity ue = getUser(u);
        if (ue == null){
            ue = new UserEntity(u);
            System.out.println("J'ajoute : "+u.getLogin());
            em.persist(ue);
        }
        return ue;
    }

    public UserEntity getUser(UserDTO u) {
        UserEntity v = null;
        TypedQuery<UserEntity> query = em.createQuery("SELECT ue FROM UserEntity ue Where ue.login = '"+u.getLogin()+"' ", UserEntity.class);
        System.out.println(query.getResultList().size());
        if (query.getResultList().size() > 0)
            v = query.getSingleResult();
        return v;
    }

    public int deleteUser(int id){
       Query query = em.createNamedQuery("UserEntity.deleteOne");
       query.setParameter(1, id);
       return query.executeUpdate();
    }

    public UserEntity getUserByLogin(String login) {
        UserEntity v = null;
        TypedQuery<UserEntity> query = em.createQuery("SELECT ue FROM UserEntity ue Where ue.login = '"+login+"' ", UserEntity.class);
        System.out.println(query.getResultList().size());
        if (query.getResultList().size() > 0)
            v = query.getSingleResult();
        return v;
    }
}
