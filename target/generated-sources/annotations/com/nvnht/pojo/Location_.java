package com.nvnht.pojo;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Routes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-05T16:31:34")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> streetName;
    public static volatile SetAttribute<Location, Routes> routesSet;
    public static volatile SingularAttribute<Location, String> cityName;
    public static volatile SingularAttribute<Location, String> districtName;
    public static volatile SingularAttribute<Location, Buscompanies> buscompaniesId;
    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile SetAttribute<Location, Routes> routesSet1;

}