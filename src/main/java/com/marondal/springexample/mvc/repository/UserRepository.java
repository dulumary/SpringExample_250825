package com.marondal.springexample.mvc.repository;

import com.marondal.springexample.mvc.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    public int insertUser(
            @Param("name") String name
            , @Param("birthday") String birthday
            , @Param("email") String email
            , @Param("introduce") String introduce);

    public int insertUserByObject(User user);

    public User selectLastUser();

    // 일치하는 email이 있는 행의 개수 조회
    public int selectCountByEmail(@Param("email") String email);

}
