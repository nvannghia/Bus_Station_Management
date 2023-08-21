package com.nvnht.pojo;

import com.nvnht.pojo.Shipmentdetails;
import com.nvnht.pojo.Trips;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-21T14:23:42")
@StaticMetamodel(Deliveries.class)
public class Deliveries_ { 

    public static volatile SingularAttribute<Deliveries, Shipmentdetails> senderId;
    public static volatile SingularAttribute<Deliveries, Integer> quantity;
    public static volatile SingularAttribute<Deliveries, Shipmentdetails> receiverId;
    public static volatile SingularAttribute<Deliveries, Date> deliveryTime;
    public static volatile SingularAttribute<Deliveries, Double> fee;
    public static volatile SingularAttribute<Deliveries, Double> weight;
    public static volatile SingularAttribute<Deliveries, Integer> id;
    public static volatile SingularAttribute<Deliveries, Date> shippingTime;
    public static volatile SingularAttribute<Deliveries, Trips> tripsId;

}