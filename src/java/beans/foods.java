/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Sairam Pillai
 */
import java.io.Serializable;
import java.lang.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="foods")
public class foods implements Serializable {
    @Id @GeneratedValue
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="hotel")
    private String hotel;
    @Column(name="type")
    private String type;
    @Column(name="price")
    private Integer price;
    public foods(){}
    public foods(String name,String hotel, String type, Integer price ){
        this.name=name;
        this.hotel=hotel;
        this.type=type;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public String getHotel(){
        return hotel;
    }
    public String getType(){
        return type;
    }
    public Integer getPrice(){
        return price;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String name){this.name=name;}
    public void setHotel(String hotel){this.hotel=hotel;}
    public void setType(String type){this.type=type;}
    public void setPrice(Integer price){this.price=price;}
    public void setId(Integer id){this.id=id;}
    
}
