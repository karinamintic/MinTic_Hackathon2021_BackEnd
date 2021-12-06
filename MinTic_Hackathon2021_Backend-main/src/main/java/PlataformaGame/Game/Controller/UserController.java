/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlataformaGame.Game.Controller;

import PlataformaGame.Game.Model.User;
import PlataformaGame.Game.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raque
 */
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService servicios;
    
    // find all users  
    @GetMapping("/all")
    public List<User> getUser() {
        return servicios.getAll();
    }
    
    // find by user and pass
    @GetMapping("/{nameUser}/{password}")
    public User getUser(@PathVariable String nameUser, @PathVariable String password ) {
        User user = servicios.getExistsUserAndPassword(nameUser, password);
        if (user == null) {

            User noUser = new User(null, "NO DEFINIDO", password);

            return noUser;
        }
        return user;
//        return servicios.getExistsByUser(nameUser, password);
    }
    
    
//    @GetMapping("/{nameUser}/{password}")
//    public User getEmailAndPassword(@PathVariable String nameUser, @PathVariable String password) {
//
//        User user = servicios.getExistsNameUserAndPassword(email, password);
//        if (user == null) {
//
//            User noUser = new User(null, email, "NO DEFINIDO", password);
//
//            return noUser;
//        }
//        return user;
//    }
    
   
    // Ingresar un nuevo usuario    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) throws Exception {

        return servicios.save(user);

    }
    
    // Actualización de datos
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicios.update(user);
    }
    
    
    
    
}
