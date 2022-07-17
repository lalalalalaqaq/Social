package com.edu.social.controller;

import com.edu.social.common.BaseResponse;
import com.edu.social.common.ErrorCode;
import com.edu.social.common.ResultUtils;
import com.edu.social.mapper.SubscribeMapper;
import com.edu.social.model.request.SubscribeRequest;
import com.edu.social.service.SubscribeService;
import com.edu.social.service.UserService;
import org.apache.commons.lang3.StringUtils;
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

        if (StringUtils.isAnyBlank(userSubscribeRequest.SubUserAccount) || userSubscribeRequest.beSubUserAccount.length == 0) {
            return null;
        }
        boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        if ( b == true){
            return ResultUtils.success(b);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }

    @PostMapping("/Mutil")
    public BaseResponse<Boolean> SubMutil(@RequestBody SubscribeRequest userSubscribeRequest){

        boolean b = subscribeService.SubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        if ( b == true){
            return ResultUtils.success(b);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }

    @DeleteMapping("/One")
    public BaseResponse<Boolean> delSubOne(@RequestBody SubscribeRequest userSubscribeRequest){

        boolean b = subscribeService.delSubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        if ( b == true){
            return ResultUtils.success(b);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }

    @DeleteMapping("/Mutil")
    public BaseResponse<Boolean> delSubMutil(@RequestBody SubscribeRequest userSubscribeRequest){
        boolean b = subscribeService.delSubscribeMutil(userSubscribeRequest.SubUserAccount, userSubscribeRequest.beSubUserAccount);
        if ( b == true){
            return ResultUtils.success(b);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }
}
