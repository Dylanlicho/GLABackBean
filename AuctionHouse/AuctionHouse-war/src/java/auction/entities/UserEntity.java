/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.UserDTO;
import java.util.Set;
import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author attuku
 */
@Entity
@NamedQuery(name= "UserEntity.deleteOne", 
            query="DELETE FROM UserEntity ue WHERE ue.id = ?1")
@NamedQuery(name= "UserEntity.getAll", 
            query="SELECT ue FROM UserEntity ue")
@NamedQuery(name= "UserEntity.getParticipations", 
            query="SELECT ue.participations FROM UserEntity ue")

@Table(name = "users")
public class UserEntity  {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="LOGIN", unique=true)
    private String login;
    private String firstname;
    private String lastname;
    private String address;
    private String password;
    
    /*@OneToMany(mappedBy="seller")
    private Set<ArticleEntity> articles;
    */
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    Set<ParticipationEntity> participations;

    public UserEntity(){}

    public UserEntity(UserDTO u) {
        this.id = u.getId();
        this.login = u.getLogin();
        this.password = u.getPassword();
        this.firstname = u.getFirstname();
        this.lastname = u.getLastname();
        this.address = u.getAddress();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ParticipationEntity> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<ParticipationEntity> participations) {
        this.participations = participations;
    }
    
}
