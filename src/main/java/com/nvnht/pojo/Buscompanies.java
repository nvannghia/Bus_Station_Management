/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nghia
 */
@Entity
@Table(name = "buscompanies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buscompanies.findAll", query = "SELECT b FROM Buscompanies b"),
    @NamedQuery(name = "Buscompanies.findById", query = "SELECT b FROM Buscompanies b WHERE b.id = :id"),
    @NamedQuery(name = "Buscompanies.findByName", query = "SELECT b FROM Buscompanies b WHERE b.name = :name"),
    @NamedQuery(name = "Buscompanies.findByPhoneNumber", query = "SELECT b FROM Buscompanies b WHERE b.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Buscompanies.findByDelivery", query = "SELECT b FROM Buscompanies b WHERE b.delivery = :delivery"),
    @NamedQuery(name = "Buscompanies.findByActive", query = "SELECT b FROM Buscompanies b WHERE b.active = :active"),
    @NamedQuery(name = "Buscompanies.findByIdUser", query = "SELECT b FROM Buscompanies b WHERE b.idUser = :idUser")})
public class Buscompanies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false) 
    @NotNull(message = "{buscompany.name.notNull}")
    @Size(min = 1, max = 45, message = "{buscompany.name.lenErr}")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull(message = "{buscompany.phoneNumber.notNull}")
    @Size(min = 10, max = 20, message = "{buscompany.phoneNumber.lenErr}")
    @Pattern(regexp = "^[0-9]*$", message = "{buscompany.phoneNumber.onlyNumber}")
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery")
    private short delivery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buscompaniesId")
    private Set<Routes> routesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buscompaniesId")
    private Set<Ticket> ticketSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buscompaniesId")
    private Set<Review> reviewSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buscompaniesId")
    private Set<Location> locationSet;

    public Buscompanies() {
    }

    public Buscompanies(Integer id) {
        this.id = id;
    }

    public Buscompanies(Integer id, String name, String phoneNumber, short delivery, short active, int idUser) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.delivery = delivery;
        this.active = active;
        this.idUser = idUser;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public short getDelivery() {
        return delivery;
    }

    public void setDelivery(short delivery) {
        this.delivery = delivery;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Set<Routes> getRoutesSet() {
        return routesSet;
    }

    public void setRoutesSet(Set<Routes> routesSet) {
        this.routesSet = routesSet;
    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @XmlTransient
    public Set<Review> getReviewSet() {
        return reviewSet;
    }

    public void setReviewSet(Set<Review> reviewSet) {
        this.reviewSet = reviewSet;
    }

    @XmlTransient
    public Set<Location> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<Location> locationSet) {
        this.locationSet = locationSet;
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
        if (!(object instanceof Buscompanies)) {
            return false;
        }
        Buscompanies other = (Buscompanies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Buscompanies[ id=" + id + " ]";
    }
    
}
