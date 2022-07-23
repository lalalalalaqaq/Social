package com.edu.social.controller;

import com.edu.social.common.BaseResponse;
import com.edu.social.common.ErrorCode;
import com.edu.social.common.ResultUtils;
import com.edu.social.exception.BusinessException;
import com.edu.social.mapper.ArticleMapper;
import com.edu.social.model.entity.Article;
import com.edu.social.model.request.ArticleRequest;
import com.edu.social.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : orange.Zhang
 * @date : 2022-07-23
 **/
@RestController
@RequestMapping("/Article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    ArticleMapper articleMapper;

    @GetMapping("/findAll")
    public BaseResponse<List<Article>> findAllArticle(){
        return ResultUtils.success(articleMapper.findAllarticle());
    }

    @GetMapping("/find")
    public BaseResponse<List<Article>> find(@RequestParam(value = "startIndex") Integer startIndex,
                                            @RequestParam(value = "pageSize") Integer pageSize){
        if (startIndex < 0 || startIndex > 10 || pageSize < 0 || pageSize > 10){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(articleService.readArticle(startIndex,pageSize));
    }

    @PostMapping("/write")
    public BaseResponse<Boolean> write(@RequestBody ArticleRequest articleRequest){
        if (StringUtils.isAnyBlank(articleRequest.getTitle(),articleRequest.getContent(),articleRequest.getUseraccount())){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(articleService.save(articleService.newArticle(articleRequest)));
    }

}
