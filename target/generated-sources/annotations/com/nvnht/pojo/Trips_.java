package com.nvnht.pojo;

import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-05T20:47:45")
@StaticMetamodel(Trips.class)
public class Trips_ { 

    public static volatile SingularAttribute<Trips, Integer> hour;
    public static volatile SetAttribute<Trips, Ticket> ticketSet;
    public static volatile SingularAttribute<Trips, Routes> routesId;
    public static volatile SingularAttribute<Trips, String> licensePlates;
    public static volatile SingularAttribute<Trips, Integer> id;
    public static volatile SingularAttribute<Trips, String> departureDate;
    public static volatile SingularAttribute<Trips, Integer> seatNumber;
    public static volatile SingularAttribute<Trips, Integer> minute;

}