package com.marondal.springexample.database;

import com.marondal.springexample.database.domain.UsedGoods;
import com.marondal.springexample.database.service.UsedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsedGoodsController {

    @Autowired
    private UsedGoodsService usedGoodsService;

    // 중고 거래 게시글 모든 정보를 response 에 담는다
    @RequestMapping("/db/usedgoods/list")
    @ResponseBody
    public List<UsedGoods> usedGoodsList() {

        // 중고 거래 게시글 정보 얻어오기
        List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();

        return usedGoodsList;
    }
}
