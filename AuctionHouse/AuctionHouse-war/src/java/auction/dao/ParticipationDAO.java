/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.dto.ParticipationDTO;
import auction.entities.ArticleEntity;
import auction.entities.ParticipationEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class ParticipationDAO {
    @PersistenceContext(unitName="UserPU")
    EntityManager em;
    
    public ParticipationEntity bestParticipationByIdArticle(int idArticle) {
        ParticipationEntity ret = null;
        TypedQuery<ParticipationEntity> query = em.createQuery("SELECT pae "
                                                             + "FROM ParticipationEntity pae "
                                                             + "Where pae.price = (SELECT MAX(pae.price) "
                                                                                + "FROM ParticipationEntity pae "
                                                                                + "WHERE pae.idArticle = "+idArticle+" ) "
                                                             + "AND pae.idArticle = "+idArticle+"", ParticipationEntity.class);
        if (query.getResultList().size() > 0)
            ret = query.getSingleResult();
        return ret;
    }

    public ParticipationEntity createParticipation(ParticipationDTO participationDTO) {
        ParticipationEntity ret = new ParticipationEntity(participationDTO);
        em.persist(ret);
        return ret;
    }
    
    
    public ParticipationEntity updateParticipation(ParticipationDTO participationDTO) {
        int idArticle = participationDTO.getIdArticle();
        int idUser = participationDTO.getIdUser();
        ParticipationEntity ret = null;
        TypedQuery<ParticipationEntity> query = em.createQuery("SELECT pae "
                                                     + "FROM ParticipationEntity pae "
                                                     + "Where pae.idArticle = "+idArticle+" "
                                                     + "AND pae.idUser = "+idUser, ParticipationEntity.class);
        if (query.getResultList().size() > 0){
            ret = query.getSingleResult();
            ret.setPrice(participationDTO.getPrice());
            em.merge(ret);
        } else
            em.persist(ret);
        return ret;
    }

    public List<ArticleEntity> participationByIdUser(int idUser) {
        return null;
    }
}
