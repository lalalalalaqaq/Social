package com.edu.social.controller;

import com.edu.social.common.BaseResponse;
import com.edu.social.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : orange.Zhang
 * @date : 2022-07-16
 **/
@RestController
public class helloController {

    @GetMapping("/hello")
    public BaseResponse<Long> hello() {
        return ResultUtils.success(new Date().getTime());
    }
}
