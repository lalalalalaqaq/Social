package com.edu.social.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.social.model.entity.Article;
import com.edu.social.model.request.ArticleRequest;
import com.edu.social.service.ArticleService;
import com.edu.social.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
* @author 86135
* @description 针对表【article(文章)】的数据库操作Service实现
* @createDate 2022-07-23 17:41:33
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    @Resource
    ArticleMapper articleMapper;

    @Override
    public List<Article> readArticle(Integer startIndex, Integer pageSize) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("pageSize", pageSize);
        return articleMapper.articleLimit(map);
    }

    @Override
    public Article newArticle(ArticleRequest articleRequest) {
        Article article = new Article();


        article.setContent(articleRequest.getContent());
        article.setTitle(articleRequest.getTitle());
        article.setUseraccount(articleRequest.getUseraccount());
        article.setUsername(articleRequest.getUsername());
        article.setCreatetime(new Date());
        article.setUpdatetime(new Date());
        return article;
    }

    @Override
    public Boolean writeArticle(Article article) {
        return this.save(article);
    }

}




