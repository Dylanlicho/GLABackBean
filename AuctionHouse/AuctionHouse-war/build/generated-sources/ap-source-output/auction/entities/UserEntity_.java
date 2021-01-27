package auction.entities;

import auction.entities.ParticipationEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-27T21:41:44")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ { 

    public static volatile SingularAttribute<UserEntity, String> firstname;
    public static volatile SingularAttribute<UserEntity, String> password;
    public static volatile SetAttribute<UserEntity, ParticipationEntity> participations;
    public static volatile SingularAttribute<UserEntity, String> address;
    public static volatile SingularAttribute<UserEntity, Integer> id;
    public static volatile SingularAttribute<UserEntity, String> login;
    public static volatile SingularAttribute<UserEntity, String> lastname;

}