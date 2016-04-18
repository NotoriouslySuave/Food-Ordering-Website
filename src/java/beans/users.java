package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sairam Pillai
 */
import java.io.Serializable;
import java.lang.*;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class users implements Serializable {
    @Column(name="uname")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Id @GeneratedValue
    private Integer id;
    public users(){}
    public users(String uname,String password, String name, String email ){
        this.username=uname;
        this.password=password;
        this.name=name;
        this.email=email;
    }
    public Integer getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setUsername(String uname){this.username=uname;}
    public void setPassword(String password){this.password=password;}
    public void setName(String name){this.name=name;}
    public void setEmail(String email){this.email=email;}
    
    
}
