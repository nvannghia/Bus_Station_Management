/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.service.impl;

import com.nvnht.pojo.Buscompanies;
import com.nvnht.pojo.Review;
import com.nvnht.repository.ReviewRepository;
import com.nvnht.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nghia
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    
    @Autowired
    private ReviewRepository reviewRepo;
    @Override
    public boolean addReview(Review review) {
        return this.reviewRepo.addReview(review);
    }

    @Override
    public List<Review> getReviewsByBusCompany(Buscompanies b) {
        return this.reviewRepo.getReviewsByBusCompany(b);
    }

    @Override
    public double getNumberStarByBus(Buscompanies bus) {
        return this.reviewRepo.getNumberStarByBus(bus);
    }
    
}
