package com.marondal.springexample.mybatis.repository;

import com.marondal.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {

    // 전달은 id와 일치하는 new_review 테이블의 행 조회
    public Review selectReview(@Param("id") int id);

    // review 테이블에 한행을 저장하는 기능
    public int insertReview(
            @Param("storeId") int storeId
            , @Param("menu") String menu
            , @Param("userName") String userName
            , @Param("point") double point
            , @Param("review") String review);

    // Review 객체를 전달해서 new_review에 저장하는 기능
    public int insertReviewByObject(Review review);

}
