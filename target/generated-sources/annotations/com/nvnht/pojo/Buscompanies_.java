package com.nvnht.pojo;

import com.nvnht.pojo.Location;
import com.nvnht.pojo.Review;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-14T12:34:27")
@StaticMetamodel(Buscompanies.class)
public class Buscompanies_ { 

    public static volatile SingularAttribute<Buscompanies, Short> delivery;
    public static volatile SingularAttribute<Buscompanies, String> phoneNumber;
    public static volatile CollectionAttribute<Buscompanies, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Buscompanies, Routes> routesCollection;
    public static volatile SingularAttribute<Buscompanies, String> name;
    public static volatile SingularAttribute<Buscompanies, Short> active;
    public static volatile SingularAttribute<Buscompanies, Integer> id;
    public static volatile CollectionAttribute<Buscompanies, Review> reviewCollection;
    public static volatile CollectionAttribute<Buscompanies, Location> locationCollection;

}