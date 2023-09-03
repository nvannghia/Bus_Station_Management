package com.nvnht.pojo;

import com.nvnht.pojo.Location;
import com.nvnht.pojo.Review;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-03T21:01:18")
@StaticMetamodel(Buscompanies.class)
public class Buscompanies_ { 

    public static volatile SingularAttribute<Buscompanies, Integer> idUser;
    public static volatile SingularAttribute<Buscompanies, Short> delivery;
    public static volatile SingularAttribute<Buscompanies, String> phoneNumber;
    public static volatile SetAttribute<Buscompanies, Routes> routesSet;
    public static volatile SetAttribute<Buscompanies, Ticket> ticketSet;
    public static volatile SetAttribute<Buscompanies, Location> locationSet;
    public static volatile SingularAttribute<Buscompanies, String> name;
    public static volatile SetAttribute<Buscompanies, Review> reviewSet;
    public static volatile SingularAttribute<Buscompanies, Short> active;
    public static volatile SingularAttribute<Buscompanies, Integer> id;

}