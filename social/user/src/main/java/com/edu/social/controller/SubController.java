package com.edu.social.controller;

import com.edu.social.common.BaseResponse;
import com.edu.social.common.ResultUtils;
import com.edu.social.mapper.SubscribeMapper;
import com.edu.social.model.request.SubscribeRequest;
import com.edu.social.service.SubscribeService;
import com.edu.social.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : orange.Zhang
 * @date : 2022-07-16
 **/
@RestController
@RequestMapping("/sub")
public class SubController {

    @Resource
    private SubscribeMapper subscribeMapper;

    @Resource
    private SubscribeService subscribeService;

    @PostMapping("/One")
    public BaseResponse<Boolean> SubOne(@RequestBody SubscribeRequest userSubscribeRequest){

        boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        return ResultUtils.success(b);
    }

    @PostMapping("/Mutil")
    public BaseResponse<Boolean> SubMutil(@RequestBody SubscribeRequest userSubscribeRequest){

        final boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        return ResultUtils.success(b);
    }

    @DeleteMapping("/One")
    public BaseResponse<Boolean> delSubOne(@RequestBody SubscribeRequest userSubscribeRequest){

        final boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        return ResultUtils.success(b);
    }

    @DeleteMapping("/Mutil")
    public BaseResponse<Boolean> delSubMutil(@RequestBody SubscribeRequest userSubscribeRequest){
        final boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        return ResultUtils.success(b);
    }
}
