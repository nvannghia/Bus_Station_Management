/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author 84967
 */
@Entity
@Table(name = "deliveries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveries.findAll", query = "SELECT d FROM Deliveries d"),
    @NamedQuery(name = "Deliveries.findById", query = "SELECT d FROM Deliveries d WHERE d.id = :id"),
    @NamedQuery(name = "Deliveries.findByShippingTime", query = "SELECT d FROM Deliveries d WHERE d.shippingTime = :shippingTime"),
    @NamedQuery(name = "Deliveries.findByDeliveryTime", query = "SELECT d FROM Deliveries d WHERE d.deliveryTime = :deliveryTime"),
    @NamedQuery(name = "Deliveries.findByFee", query = "SELECT d FROM Deliveries d WHERE d.fee = :fee"),
    @NamedQuery(name = "Deliveries.findByQuantity", query = "SELECT d FROM Deliveries d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "Deliveries.findByWeight", query = "SELECT d FROM Deliveries d WHERE d.weight = :weight")})
public class Deliveries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_time")
    @Temporal(TemporalType.TIME)
    private Date shippingTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_time")
    @Temporal(TemporalType.TIME)
    private Date deliveryTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fee")
    private Double fee;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "weight")
    private Double weight;
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shipmentdetails receiverId;
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shipmentdetails senderId;
    @JoinColumn(name = "trips_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Trips tripsId;

    public Deliveries() {
    }

    public Deliveries(Integer id) {
        this.id = id;
    }

    public Deliveries(Integer id, Date shippingTime, Date deliveryTime) {
        this.id = id;
        this.shippingTime = shippingTime;
        this.deliveryTime = deliveryTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Shipmentdetails getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Shipmentdetails receiverId) {
        this.receiverId = receiverId;
    }

    public Shipmentdetails getSenderId() {
        return senderId;
    }

    public void setSenderId(Shipmentdetails senderId) {
        this.senderId = senderId;
    }

    public Trips getTripsId() {
        return tripsId;
    }

    public void setTripsId(Trips tripsId) {
        this.tripsId = tripsId;
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
        if (!(object instanceof Deliveries)) {
            return false;
        }
        Deliveries other = (Deliveries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Deliveries[ id=" + id + " ]";
    }
    
}
