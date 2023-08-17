/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 84967
 */
@Entity
@Table(name = "trips")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trips.findAll", query = "SELECT t FROM Trips t"),
    @NamedQuery(name = "Trips.findById", query = "SELECT t FROM Trips t WHERE t.id = :id"),
    @NamedQuery(name = "Trips.findByDepartureDate", query = "SELECT t FROM Trips t WHERE t.departureDate = :departureDate"),
    @NamedQuery(name = "Trips.findByDepartureTime", query = "SELECT t FROM Trips t WHERE t.departureTime = :departureTime"),
    @NamedQuery(name = "Trips.findByLicensePlates", query = "SELECT t FROM Trips t WHERE t.licensePlates = :licensePlates"),
    @NamedQuery(name = "Trips.findBySeatNumber", query = "SELECT t FROM Trips t WHERE t.seatNumber = :seatNumber")})
public class Trips implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departure_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "license_plates")
    private String licensePlates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_number")
    private int seatNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripsId")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "routes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Routes routesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripsId")
    private Collection<Deliveries> deliveriesCollection;

    public Trips() {
    }

    public Trips(Integer id) {
        this.id = id;
    }

    public Trips(Integer id, Date departureDate, Date departureTime, String licensePlates, int seatNumber) {
        this.id = id;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.licensePlates = licensePlates;
        this.seatNumber = seatNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Routes getRoutesId() {
        return routesId;
    }

    public void setRoutesId(Routes routesId) {
        this.routesId = routesId;
    }

    @XmlTransient
    public Collection<Deliveries> getDeliveriesCollection() {
        return deliveriesCollection;
    }

    public void setDeliveriesCollection(Collection<Deliveries> deliveriesCollection) {
        this.deliveriesCollection = deliveriesCollection;
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
        if (!(object instanceof Trips)) {
            return false;
        }
        Trips other = (Trips) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Trips[ id=" + id + " ]";
    }
}
