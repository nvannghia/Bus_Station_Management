/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nghia
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id"),
    @NamedQuery(name = "Ticket.findBySeatNumber", query = "SELECT t FROM Ticket t WHERE t.seatNumber = :seatNumber"),
    @NamedQuery(name = "Ticket.findByPayment", query = "SELECT t FROM Ticket t WHERE t.payment = :payment"),
    @NamedQuery(name = "Ticket.findByCreatedAt", query = "SELECT t FROM Ticket t WHERE t.createdAt = :createdAt")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_number")
    private int seatNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment")
    private short payment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sold")
    private short sold;
    
    
    @JoinColumn(name = "buscompanies_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Buscompanies buscompaniesId;
   
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER,optional = false, cascade = CascadeType.ALL)
    private Trips tripsId;
   
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket(Integer id, int seatNumber, short payment, Date createdAt) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.payment = payment;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public short getPayment() {
        return payment;
    }

    public void setPayment(short payment) {
        this.payment = payment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Buscompanies getBuscompaniesId() {
        return buscompaniesId;
    }

    public void setBuscompaniesId(Buscompanies buscompaniesId) {
        this.buscompaniesId = buscompaniesId;
    }

    public Trips getTripsId() {
        return tripsId;
    }

    public void setTripsId(Trips tripsId) {
        this.tripsId = tripsId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Ticket[ id=" + id + " ]";
    }

    /**
     * @return the sold
     */
    public short getSold() {
        return sold;
    }

    /**
     * @param sold the sold to set
     */
    public void setSold(short sold) {
        this.sold = sold;
    }
    
}
