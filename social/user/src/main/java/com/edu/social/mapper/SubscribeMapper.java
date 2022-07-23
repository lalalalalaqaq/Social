package com.edu.social.mapper;

import com.edu.social.model.entity.Subscribe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.social.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 86135
* @description 针对表【subscribe(关注表)】的数据库操作Mapper
* @createDate 2022-07-14 00:09:44
* @Entity com.edu.social.model.entity.Subscribe
*/
@Mapper
public interface SubscribeMapper extends BaseMapper<Subscribe> {

    @Select("select  count(id) from subscribe where id = #{relationCode}")
    Integer findSubrelation(Integer relationCode);

    @Select("select beSubuser from subscribe where Subuser = #{Subuser}")
    List<String> findRelation(String Subuser);

    @Update("update subscribe set isdelete = 1 , updateTime = current_timestamp() where id = #{relationCode}")
    Integer cancleSubrelation(Integer relationCode);

    @Update("update subscribe set isdelete = 0 , updateTime = current_timestamp() where id = #{relationCode}")
    Integer updateSubrelation(Integer relationCode);

    @Select("SELECT * FROM user where userAccount not in (SELECT beSubuser FROM subscribe where Subuser = #{sub})")
    List<User> RecommendedUsersToFollow(String sub);

}




