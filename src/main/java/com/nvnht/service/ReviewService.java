/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Review;
import java.util.List;

/**
 *
 * @author nghia
 */
public interface ReviewService {
    boolean addReview(Review review);
    List<Review> getReviewsByBusCompany(Buscompanies b);
    double getNumberStarByBus(Buscompanies bus);
}
