/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 84967
 */
@Entity
@Table(name = "shipmentdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipmentdetails.findAll", query = "SELECT s FROM Shipmentdetails s"),
    @NamedQuery(name = "Shipmentdetails.findById", query = "SELECT s FROM Shipmentdetails s WHERE s.id = :id"),
    @NamedQuery(name = "Shipmentdetails.findByFullname", query = "SELECT s FROM Shipmentdetails s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "Shipmentdetails.findByEmail", query = "SELECT s FROM Shipmentdetails s WHERE s.email = :email"),
    @NamedQuery(name = "Shipmentdetails.findByPhoneNumber", query = "SELECT s FROM Shipmentdetails s WHERE s.phoneNumber = :phoneNumber")})
public class Shipmentdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 85)
    @Column(name = "fullname")
    private String fullname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverId")
    private Collection<Deliveries> deliveriesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private Collection<Deliveries> deliveriesCollection1;

    public Shipmentdetails() {
    }

    public Shipmentdetails(Integer id) {
        this.id = id;
    }

    public Shipmentdetails(Integer id, String fullname, String email, String phoneNumber, String address) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Deliveries> getDeliveriesCollection() {
        return deliveriesCollection;
    }

    public void setDeliveriesCollection(Collection<Deliveries> deliveriesCollection) {
        this.deliveriesCollection = deliveriesCollection;
    }

    @XmlTransient
    public Collection<Deliveries> getDeliveriesCollection1() {
        return deliveriesCollection1;
    }

    public void setDeliveriesCollection1(Collection<Deliveries> deliveriesCollection1) {
        this.deliveriesCollection1 = deliveriesCollection1;
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
        if (!(object instanceof Shipmentdetails)) {
            return false;
        }
        Shipmentdetails other = (Shipmentdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Shipmentdetails[ id=" + id + " ]";
    }
    
}
