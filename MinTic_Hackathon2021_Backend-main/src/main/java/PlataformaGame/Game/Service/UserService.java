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
    
    /**
     * Consult all users 
     */ 
    public List<User> getAll(){
        return metodosCrud.getAll();
    }
    
//    public User getExistsByUser(String nameUser, String password){
//        return metodosCrud.getExistsByUser(nameUser, password);
//    }
    
    public User getExistsUserAndPassword(String nameUser, String password){
        
        return metodosCrud.getExistsEmailAndPassword(nameUser,password);
    }
    
    // Save new user      
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
    
    
    // Update data user
    public User update(User user){
        if (user.getId()!=null){
            Optional<User> evt = metodosCrud.getUser(user.getId());
            if (!evt.isEmpty()){
                if (user.getName()!=null){
                    evt.get().setName(user.getName());
                }
                if (user.getNameUser()!=null){
                    evt.get().setNameUser(user.getNameUser());
                }
                if (user.getPassword()!=null){
                    evt.get().setPassword(user.getPassword());
                }
                
                metodosCrud.save(evt.get());
                return evt.get();
            }else {
                return user;
            }
        }else {
            return user;
        }
    }
    
    
}
