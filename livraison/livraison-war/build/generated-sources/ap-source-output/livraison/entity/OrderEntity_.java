package livraison.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-28T00:11:40")
@StaticMetamodel(OrderEntity.class)
public class OrderEntity_ { 

    public static volatile SingularAttribute<OrderEntity, String> date;
    public static volatile SingularAttribute<OrderEntity, String> address;
    public static volatile SingularAttribute<OrderEntity, Integer> idArticle;
    public static volatile SingularAttribute<OrderEntity, Integer> id;
    public static volatile SingularAttribute<OrderEntity, Integer> buyer;
    public static volatile SingularAttribute<OrderEntity, String> nameArticle;

}