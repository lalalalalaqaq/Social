package com.edu.social.service;

import com.edu.social.model.entity.Subscribe;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86135
* @description 针对表【subscribe(关注表)】的数据库操作Service
* @createDate 2022-07-14 00:09:44
*/
public interface SubscribeService extends IService<Subscribe> {

    /**
     * 关注一个
     * @return
     */
    Boolean SubscribeOne(String beSubUserAccount, String SubUserAccount);

    /**
     * 关注多个
     * @return
     */
    Integer SubscribeMutil(String beSubUserAccount, List<String> SubUserAccount);

}
