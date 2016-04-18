/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sairam Pillai
 */
@Entity
@Table(name = "pending")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pending.findAll", query = "SELECT p FROM Pending p"),
    @NamedQuery(name = "Pending.findById", query = "SELECT p FROM Pending p WHERE p.id = :id"),
    @NamedQuery(name = "Pending.findByUname", query = "SELECT p FROM Pending p WHERE p.uname = :uname"),
    @NamedQuery(name = "Pending.findByName", query = "SELECT p FROM Pending p WHERE p.name = :name"),
    @NamedQuery(name = "Pending.findByHotel", query = "SELECT p FROM Pending p WHERE p.hotel = :hotel"),
    @NamedQuery(name = "Pending.findByPrice", query = "SELECT p FROM Pending p WHERE p.price = :price")})
public class Pending implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uname")
    private String uname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "hotel")
    private String hotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;

    public Pending() {
    }

    public Pending(Integer id) {
        this.id = id;
    }

    public Pending(Integer id, String uname, String name, String hotel, int price) {
        this.id = id;
        this.uname = uname;
        this.name = name;
        this.hotel = hotel;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pending)) {
            return false;
        }
        Pending other = (Pending) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Pending[ id=" + id + " ]";
    }
    
}
