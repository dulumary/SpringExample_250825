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

    // 리뷰정보를 전달 받고, 리뷰를 추가하는 기능
    public int createReview(
            int storeId
            , String menu
            , String userName
            , double point
            , String review) {

        // review 테이블에 한행을 저장 하는 기능
        int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
        return count;
    }

    // 리뷰정보를 객체로 전달받고 저장하는 기능
    public int createReviewByObject(Review review) {

        // Review 객체를 전달해서 new_review에 저장하는 기능
        int count = reviewRepository.insertReviewByObject(review);

        return count;
    }



}
