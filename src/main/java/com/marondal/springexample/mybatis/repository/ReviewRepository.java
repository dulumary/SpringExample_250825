package com.marondal.springexample.mybatis.repository;

import com.marondal.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewRepository {

    // 전달은 id와 일치하는 new_review 테이블의 행 조회
    public Review selectReview(@Param("id") int id);



}
