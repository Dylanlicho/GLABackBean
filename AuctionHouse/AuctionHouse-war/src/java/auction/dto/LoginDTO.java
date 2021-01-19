/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dto;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author attuku
 */

public class LoginDTO {
    @XmlElement
    private String login;    
    @XmlElement
    private String password;

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
