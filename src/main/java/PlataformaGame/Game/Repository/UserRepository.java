/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlataformaGame.Game.Repository;

import PlataformaGame.Game.Interface.UserInterface;
import PlataformaGame.Game.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raque
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface crud;
    
    public List<User> getAll(){
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getUser(int id){
        return crud.findById(id);
    }
    
    public boolean getExistsUser(String nameUser){
        return crud.existsByUser(nameUser);
    }
    
    public User getExistsUserAndPassword(String nameUser, String password){
        return crud.findAllByUserAndPassword(nameUser, password);
    }
    
    
    public User save(User user){
        return crud.save(user);
    }
}
