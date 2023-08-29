/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nghia
 */
@Entity
@Table(name = "routes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Routes r"),
    @NamedQuery(name = "Routes.findById", query = "SELECT r FROM Routes r WHERE r.id = :id"),
    @NamedQuery(name = "Routes.findByFare", query = "SELECT r FROM Routes r WHERE r.fare = :fare")})
public class Routes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{route.fare.notNull}")
    @Column(name = "fare")
    private Integer fare;
    @JoinColumn(name = "buscompanies_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Buscompanies buscompaniesId;
    @JoinColumn(name = "departure_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location departureId;
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location destinationId;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "routesId")
    private Set<Trips> tripsSet;

    public Routes() {
    }

    public Routes(Integer id) {
        this.id = id;
    }

    public Routes(Integer id, int fare) {
        this.id = id;
        this.fare = fare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  

    public Buscompanies getBuscompaniesId() {
        return buscompaniesId;
    }

    public void setBuscompaniesId(Buscompanies buscompaniesId) {
        this.buscompaniesId = buscompaniesId;
    }

    public Location getDepartureId() {
        return departureId;
    }

    public void setDepartureId(Location departureId) {
        this.departureId = departureId;
    }

    public Location getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Location destinationId) {
        this.destinationId = destinationId;
    }

//    @XmlTransient
//    public Set<Trips> getTripsSet() {
//        return tripsSet;
//    }
//
//    public void setTripsSet(Set<Trips> tripsSet) {
//        this.tripsSet = tripsSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routes)) {
            return false;
        }
        Routes other = (Routes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Routes[ id=" + id + " ]";
    }

    /**
     * @return the fare
     */
    public Integer getFare() {
        return fare;
    }

    /**
     * @param fare the fare to set
     */
    public void setFare(Integer fare) {
        this.fare = fare;
    }
    
}
