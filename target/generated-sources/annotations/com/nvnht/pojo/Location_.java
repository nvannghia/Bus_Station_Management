package com.nvnht.pojo;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Routes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-16T22:56:51")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> streetName;
    public static volatile SingularAttribute<Location, String> cityName;
    public static volatile SingularAttribute<Location, String> districtName;
    public static volatile CollectionAttribute<Location, Routes> routesCollection;
    public static volatile SingularAttribute<Location, Buscompanies> buscompaniesId;
    public static volatile CollectionAttribute<Location, Routes> routesCollection1;
    public static volatile SingularAttribute<Location, Integer> id;

}