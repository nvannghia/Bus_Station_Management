/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.repository;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Review;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface ReviewRepository {
    boolean addReview(Review review);
    List<Review> getReviewsByBusCompany(Buscompanies bus);
    double getNumberStarByBus(Buscompanies bus);
}
