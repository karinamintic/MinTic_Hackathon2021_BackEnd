/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlataformaGame.Game.Interface;

import PlataformaGame.Game.Model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author raque
 */
public interface UserInterface extends CrudRepository<User, Integer> {
    
    public User findAllByUserAndPassword(String nameUser,String password);
    
    boolean existsByUser(String nameUser);
    
}
