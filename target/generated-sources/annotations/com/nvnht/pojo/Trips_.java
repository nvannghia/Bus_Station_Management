package com.nvnht.pojo;

import com.nvnht.pojo.Routes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-29T15:26:20")
@StaticMetamodel(Trips.class)
public class Trips_ { 

    public static volatile SingularAttribute<Trips, Routes> routesId;
    public static volatile SingularAttribute<Trips, String> licensePlates;
    public static volatile SingularAttribute<Trips, Integer> id;
    public static volatile SingularAttribute<Trips, Date> departureDate;
    public static volatile SingularAttribute<Trips, Integer> seatNumber;

}