/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dao.ParticipationDAO;
import auction.dto.ParticipationDTO;
import auction.entities.ArticleEntity;
import auction.entities.ParticipationEntity;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class ParticipationService {
    @EJB
    ParticipationDAO participationDAO;
    
    public ParticipationEntity bestParticipationByIdArticle(int idArticle) {
        return this.participationDAO.bestParticipationByIdArticle(idArticle);
    }

    public ParticipationEntity createParticipation(ParticipationDTO participationDTO) {
        return this.participationDAO.updateParticipation(participationDTO);
    }

    public ParticipationEntity updateParticipation(ParticipationDTO participationDTO) {
        return this.participationDAO.updateParticipation(participationDTO);
    }

    public List<ArticleEntity> ParticipationByIdUser(int idUser) {
        return this.participationDAO.participationByIdUser(idUser);
    }
    
}
