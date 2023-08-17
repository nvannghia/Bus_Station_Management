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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id"),
    @NamedQuery(name = "Location.findByCityName", query = "SELECT l FROM Location l WHERE l.cityName = :cityName"),
    @NamedQuery(name = "Location.findByDistrictName", query = "SELECT l FROM Location l WHERE l.districtName = :districtName"),
    @NamedQuery(name = "Location.findByStreetName", query = "SELECT l FROM Location l WHERE l.streetName = :streetName")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city_name")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "district_name")
    private String districtName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "street_name")
    private String streetName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departureId")
    private Collection<Routes> routesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationId")
    private Collection<Routes> routesCollection1;
    @JoinColumn(name = "buscompanies_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Buscompanies buscompaniesId;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Location(Integer id, String cityName, String districtName, String streetName) {
        this.id = id;
        this.cityName = cityName;
        this.districtName = districtName;
        this.streetName = streetName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @XmlTransient
    public Collection<Routes> getRoutesCollection() {
        return routesCollection;
    }

    public void setRoutesCollection(Collection<Routes> routesCollection) {
        this.routesCollection = routesCollection;
    }

    @XmlTransient
    public Collection<Routes> getRoutesCollection1() {
        return routesCollection1;
    }

    public void setRoutesCollection1(Collection<Routes> routesCollection1) {
        this.routesCollection1 = routesCollection1;
    }

    public Buscompanies getBuscompaniesId() {
        return buscompaniesId;
    }

    public void setBuscompaniesId(Buscompanies buscompaniesId) {
        this.buscompaniesId = buscompaniesId;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.Location[ id=" + id + " ]";
    }
    
}
