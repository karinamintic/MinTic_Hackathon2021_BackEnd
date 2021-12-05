/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlataformaGame.Game.Service;

import PlataformaGame.Game.Model.User;
import PlataformaGame.Game.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class UserService {
    @Autowired
    private UserRepository metodosCrud;
    
    public List<User> getAll(){
        return metodosCrud.getAll();
    }
    
    public boolean getExistsUser(String nameUser){
        return metodosCrud.getExistsUser(nameUser);
    }
    
    public User getExistsUserAndPassword(String nameUser, String password){
        
        return metodosCrud.getExistsUserAndPassword(nameUser,password);
    }
    
    public User save(User user) throws Exception{
        
        
        if(user.getId()==null){
            return metodosCrud.save(user);
        }else{
            Optional<User> evt=metodosCrud.getUser(user.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(user);
            }else{
                return  user;
            }
        }
        
        
            
        
        
    }
}
