package com.nvnht.pojo;

import com.nvnht.pojo.Deliveries;
import com.nvnht.pojo.Routes;
import com.nvnht.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-15T22:34:54")
@StaticMetamodel(Trips.class)
public class Trips_ { 

    public static volatile SingularAttribute<Trips, Date> departureTime;
    public static volatile CollectionAttribute<Trips, Deliveries> deliveriesCollection;
    public static volatile CollectionAttribute<Trips, Ticket> ticketCollection;
    public static volatile SingularAttribute<Trips, Routes> routesId;
    public static volatile SingularAttribute<Trips, String> licensePlates;
    public static volatile SingularAttribute<Trips, Integer> id;
    public static volatile SingularAttribute<Trips, Date> departureDate;
    public static volatile SingularAttribute<Trips, Integer> seatNumber;

}