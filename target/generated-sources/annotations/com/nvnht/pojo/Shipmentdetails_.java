package com.nvnht.pojo;

import com.nvnht.pojo.Deliveries;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-15T22:34:54")
@StaticMetamodel(Shipmentdetails.class)
public class Shipmentdetails_ { 

    public static volatile CollectionAttribute<Shipmentdetails, Deliveries> deliveriesCollection;
    public static volatile SingularAttribute<Shipmentdetails, String> phoneNumber;
    public static volatile SingularAttribute<Shipmentdetails, String> address;
    public static volatile SingularAttribute<Shipmentdetails, Integer> id;
    public static volatile SingularAttribute<Shipmentdetails, String> fullname;
    public static volatile SingularAttribute<Shipmentdetails, String> email;
    public static volatile CollectionAttribute<Shipmentdetails, Deliveries> deliveriesCollection1;

}