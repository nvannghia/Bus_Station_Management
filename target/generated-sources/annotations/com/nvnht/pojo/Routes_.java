package com.nvnht.pojo;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Location;
import com.nvnht.pojo.Trips;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-14T12:34:27")
@StaticMetamodel(Routes.class)
public class Routes_ { 

    public static volatile SingularAttribute<Routes, Integer> fare;
    public static volatile CollectionAttribute<Routes, Trips> tripsCollection;
    public static volatile SingularAttribute<Routes, Buscompanies> buscompaniesId;
    public static volatile SingularAttribute<Routes, Integer> id;
    public static volatile SingularAttribute<Routes, Location> destinationId;
    public static volatile SingularAttribute<Routes, Location> departureId;

}