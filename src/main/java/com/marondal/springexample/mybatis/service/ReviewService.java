package com.marondal.springexample.mybatis.service;

import com.marondal.springexample.mybatis.domain.Review;
import com.marondal.springexample.mybatis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // 전달받은 id와 매칭되는 리뷰 정보 얻어오기
    public Review getReview(int id) {

        Review review = reviewRepository.selectReview(id);

        return review;
    }



}
