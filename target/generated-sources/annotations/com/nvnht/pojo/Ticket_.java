package com.nvnht.pojo;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Trips;
import com.nvnht.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-27T19:50:10")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Date> createdAt;
    public static volatile SingularAttribute<Ticket, Buscompanies> buscompaniesId;
    public static volatile SingularAttribute<Ticket, Short> payment;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, User> userId;
    public static volatile SingularAttribute<Ticket, Integer> seatNumber;
    public static volatile SingularAttribute<Ticket, Trips> tripsId;

}