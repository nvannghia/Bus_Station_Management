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
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nghia
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole")})
public class User implements Serializable {

    public static final String ADMIN = "admin";
    public static final String CUSTOMER = "customer";
    public static final String BUSCOMPANY = "buscompanies";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Valid
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{user.username.notNull}")
    @Size(min = 5, max = 45, message = "{user.username.lenErr}")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull(message = "{user.password.notNull}")
    @Size(min = 5, max = 100, message = "{user.password.LenErr}")
    @Column(name = "password")
    private String password;
    @Valid
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "user_role")
    private String userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Ticket> ticketSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Review> reviewSet;

    @NotNull(message = "{user.password.notMatch}")
    @Transient
    private String retypePassword;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvnht.pojo.User[ id=" + id + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    /**
     * @return the retypePassword
     */
    public String getRetypePassword() {
        return retypePassword;
    }

    /**
     * @param retypePassword the retypePassword to set
     */
    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
        checkPassword();
    }

    private void checkPassword() {
        if (this.password == null || this.retypePassword == null) {
            return;
        } else if (!this.password.equals(retypePassword)) {
            this.retypePassword = null;
        }
    }
}
