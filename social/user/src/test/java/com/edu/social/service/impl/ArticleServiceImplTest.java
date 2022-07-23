package com.edu.social.service.impl;
import java.util.ArrayList;
import java.util.Date;

import com.edu.social.mapper.ArticleMapper;
import com.edu.social.model.entity.Article;
import com.edu.social.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author : orange.Zhang
 * @date : 2022-07-23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Resource
    ArticleService articleService;

    @Resource
    ArticleMapper articleMapper;

    @Test
    public void writeAnArticle(){
        String s = "就是做个简简单单的测试没有别的意思";
        final Article article = new Article();
        article.setUseraccount("Ooorange");
        article.setUsername("");
        article.setTitle("测试文章");
        article.setCreatetime(new Date());
        article.setUpdatetime(new Date());

        ArrayList<Article> list = new ArrayList<>();
        for(int i = 0 ; i <= 10 ; i++){
            article.setContent( i + " : " + s );
            list.add(article);
        }
        articleService.saveBatch(list);
    }

    @Test
    public void AllArticle(){
        articleMapper.findAllarticle().forEach(System.out::println);
    }

    @Test
    public void articleLimit(){
        articleService.readArticle(0,5).forEach(System.out::println);
    }
}