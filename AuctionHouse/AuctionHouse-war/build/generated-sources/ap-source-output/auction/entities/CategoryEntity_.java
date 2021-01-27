package auction.entities;

import auction.entities.ArticleEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-27T21:41:44")
@StaticMetamodel(CategoryEntity.class)
public class CategoryEntity_ { 

    public static volatile SingularAttribute<CategoryEntity, String> name;
    public static volatile SingularAttribute<CategoryEntity, Integer> id;
    public static volatile SetAttribute<CategoryEntity, ArticleEntity> articles;

}