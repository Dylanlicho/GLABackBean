/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.services;

import auction.dao.UserDAO;
import auction.dto.LoginDTO;
import auction.dto.UserDTO;
import auction.entities.UserEntity;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author attuku
 */
@Stateless
@LocalBean
public class UserService {

    @EJB
    UserDAO userDao;
    
    public UserEntity register(UserDTO u) {
        return userDao.addUser(u);
    }
    
    public UserEntity getUser(UserDTO u){
        return userDao.getUser(u);
    }
    
    public int deleteUser(int id){
        return userDao.deleteUser(id);
    }

    public UserEntity getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    public UserEntity verify(LoginDTO loginDTO) {
        UserEntity ue = userDao.getUserByLogin(loginDTO.getLogin());
        if (ue != null){
            String password = ue.getPassword();
            if (password.equals(loginDTO.getPassword())){
                return ue;
            }
        }
        return null;
    }
}
