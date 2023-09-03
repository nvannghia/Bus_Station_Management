package com.nvnht.pojo;

import com.nvnht.pojo.Deliveries;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-09-03T21:01:18")
@StaticMetamodel(Shipmentdetails.class)
public class Shipmentdetails_ { 

    public static volatile SingularAttribute<Shipmentdetails, String> phoneNumber;
    public static volatile SingularAttribute<Shipmentdetails, String> address;
    public static volatile SetAttribute<Shipmentdetails, Deliveries> deliveriesSet1;
    public static volatile SetAttribute<Shipmentdetails, Deliveries> deliveriesSet;
    public static volatile SingularAttribute<Shipmentdetails, Integer> id;
    public static volatile SingularAttribute<Shipmentdetails, String> fullname;
    public static volatile SingularAttribute<Shipmentdetails, String> email;

}