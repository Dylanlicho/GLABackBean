package auction.entities;

import auction.entities.ArticleEntity;
import auction.entities.UserEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-27T21:41:44")
@StaticMetamodel(ParticipationEntity.class)
public class ParticipationEntity_ { 

    public static volatile SingularAttribute<ParticipationEntity, Integer> idUser;
    public static volatile SingularAttribute<ParticipationEntity, Integer> idArticle;
    public static volatile SingularAttribute<ParticipationEntity, Double> price;
    public static volatile SingularAttribute<ParticipationEntity, Integer> id;
    public static volatile SingularAttribute<ParticipationEntity, UserEntity> user;
    public static volatile SingularAttribute<ParticipationEntity, ArticleEntity> article;

}