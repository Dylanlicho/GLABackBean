package auction.entities;

import auction.entities.CategoryEntity;
import auction.entities.ParticipationEntity;
import auction.entities.PromotionEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-27T21:41:44")
@StaticMetamodel(ArticleEntity.class)
public class ArticleEntity_ { 

    public static volatile SingularAttribute<ArticleEntity, Integer> seller;
    public static volatile SingularAttribute<ArticleEntity, Double> startPrice;
    public static volatile SingularAttribute<ArticleEntity, Date> endDate;
    public static volatile SingularAttribute<ArticleEntity, String> name;
    public static volatile SingularAttribute<ArticleEntity, String> description;
    public static volatile SingularAttribute<ArticleEntity, Double> weight;
    public static volatile SingularAttribute<ArticleEntity, Integer> id;
    public static volatile SetAttribute<ArticleEntity, CategoryEntity> categories;
    public static volatile SingularAttribute<ArticleEntity, Date> startDate;
    public static volatile SingularAttribute<ArticleEntity, PromotionEntity> promotion;
    public static volatile SetAttribute<ArticleEntity, ParticipationEntity> participants;

}