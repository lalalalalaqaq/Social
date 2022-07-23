package com.edu.social.controller;

import com.edu.social.common.BaseResponse;
import com.edu.social.common.ResultUtils;

import org.apache.ibatis.annotations.Select;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : orange.Zhang
 * @date : 2022-07-16
 **/
@RestController
public class helloController {

    @Resource
    Environment environment;

    /**
     * 确认配置环境
     * 心跳接口
     */
    @GetMapping("/hello")
    public BaseResponse<String> hello() {
        String property = environment.getProperty("spring.profiles.active");
        return ResultUtils.success( property + " "+ new Date().getTime());
    }
}
