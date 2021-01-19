/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.entities;

import auction.dto.UserDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author attuku
 */
@Entity
@NamedQuery(name= "UserEntity.deleteOne", 
            query="DELETE FROM UserEntity ue WHERE ue.id = ?1")
@Table(name = "USERS")
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

    public UserEntity(){}

    public UserEntity(UserDTO u) {
        this.id = u.getId();
        this.login = u.getLogin();
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
}
