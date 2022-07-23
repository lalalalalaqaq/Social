package com.edu.social.service;

import com.edu.social.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.social.model.request.ArticleRequest;

import java.util.List;

/**
* @author 86135
* @description 针对表【article(文章)】的数据库操作Service
* @createDate 2022-07-23 17:41:33
*/
public interface ArticleService extends IService<Article> {

    Boolean writeArticle(Article article);

    List<Article> readArticle(Integer startIndex, Integer pageSize);

    Article newArticle(ArticleRequest articleRequest);
}
