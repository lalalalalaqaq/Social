package com.edu.social.mapper;

import com.edu.social.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where `userAccount` = #{userAccount}")
    User findOneUser(String userAccount);

    @Select("select count(*) from user where `userAccount` = #{userAccount}")
    Integer findOneByAccount(String userAccount);
}




