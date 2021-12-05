/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlataformaGame.Game.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author raque
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="user", unique = true)
    private String name;
    private String nameUser;
    private String password;
    private String repeatPassword;
    
    
    public User() {
    }
    
    public User(String nameUser) {
        this.nameUser = nameUser;
    }
    
    public User(Integer id, String name, String nameUser, String password, String repeatPassword) {
        this.id = id;
        this.name = name;
        this.nameUser = nameUser;
        this.password = password;
        this.repeatPassword = repeatPassword;
        
    }
  
 
    public User(Integer id, String nameUser, String password) {
        this.id = id;
        this.nameUser = nameUser;
        this.password = password;
        
    }
    
    public User(String nameUser,String password) {
        this.nameUser = nameUser;
        this.password = password;
        
        
    }
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    
    

}
