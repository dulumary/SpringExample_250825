package com.marondal.springexample.mybatis;

import com.marondal.springexample.mybatis.domain.Review;
import com.marondal.springexample.mybatis.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 요청한 곳에서 전달 받은 id와 일치하는 리뷰 정보를 response에 json으로 담는 페이지
    @ResponseBody
    @RequestMapping("/mybatis/review")
    public Review review(@RequestParam("id") int id) {

        // id가 14인 리뷰 정보 얻어오기
        Review review = reviewService.getReview(id);

        return review;
    }


}
