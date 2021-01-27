package auction.entities;

import auction.entities.ArticleEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-27T12:46:20")
@StaticMetamodel(PromotionEntity.class)
public class PromotionEntity_ { 

    public static volatile SingularAttribute<PromotionEntity, Integer> idArticle;
    public static volatile SingularAttribute<PromotionEntity, Integer> reduction;
    public static volatile SingularAttribute<PromotionEntity, ArticleEntity> article;

}