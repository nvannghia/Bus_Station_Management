package com.nvnht.pojo;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-24T16:46:44")
@StaticMetamodel(Review.class)
public class Review_ { 

    public static volatile SingularAttribute<Review, Integer> star;
    public static volatile SingularAttribute<Review, Buscompanies> buscompaniesId;
    public static volatile SingularAttribute<Review, Integer> id;
    public static volatile SingularAttribute<Review, User> userId;
    public static volatile SingularAttribute<Review, String> content;

}