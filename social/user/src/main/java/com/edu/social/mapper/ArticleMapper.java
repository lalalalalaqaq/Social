package com.edu.social.mapper;

import com.edu.social.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
* @author 86135
* @description 针对表【article(文章)】的数据库操作Mapper
* @createDate 2022-07-23 18:29:42
* @Entity com.edu.social.model.entity.Article
*/
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select  * from article")
    List<Article> findAllarticle();

    @Select("select * from article limit #{startIndex},#{pageSize};")
    List<Article> articleLimit(Map<String,Integer> map);
}




