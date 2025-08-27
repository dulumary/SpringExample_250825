package com.marondal.springexample.database.repository;

import com.marondal.springexample.database.domain.UsedGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsedGoodsRepository {

    // used_goods 테이블 모든 행 조회
    public List<UsedGoods> selectUsedGoodsList();

}
