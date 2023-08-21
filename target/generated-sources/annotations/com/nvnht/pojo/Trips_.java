package com.nvnht.pojo;

import com.nvnht.pojo.Deliveries;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-21T14:23:42")
@StaticMetamodel(Trips.class)
public class Trips_ { 

    public static volatile SingularAttribute<Trips, Date> departureTime;
    public static volatile SetAttribute<Trips, Ticket> ticketSet;
    public static volatile SingularAttribute<Trips, Routes> routesId;
    public static volatile SingularAttribute<Trips, String> licensePlates;
    public static volatile SetAttribute<Trips, Deliveries> deliveriesSet;
    public static volatile SingularAttribute<Trips, Integer> id;
    public static volatile SingularAttribute<Trips, Date> departureDate;
    public static volatile SingularAttribute<Trips, Integer> seatNumber;

}