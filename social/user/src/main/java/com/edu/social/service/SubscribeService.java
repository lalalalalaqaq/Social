package com.edu.social.service;

import com.edu.social.model.entity.Subscribe;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.social.model.entity.User;

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
    Boolean Subscribe(String SubUserAccount, String beSubUserAccount);

    /**
     * 关注多个
     * @return
     */
    Boolean SubscribeMutil(String beSubUserAccount, String... SubUserAccount);

    /**
     * 取消一个关注
     * @param beSubUserAccount
     * @param SubUserAccount
     * @return
     */
    Boolean delSubscribe(String beSubUserAccount, String SubUserAccount);

    /**
     * 取消多个关注
     * @param beSubUserAccount
     * @param SubUserAccount
     * @return
     */
    Boolean delSubscribeMutil(String beSubUserAccount, String... SubUserAccount);

    /**
     * 展现关注列表
     */
    List<User> showSubscribe(String Subuser);

    /**
     * 展现关注列表
     */
//    List<User> showSubscribe(String Subuser,Integer pageNum, Integer pageSize);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    void getSafetyUser(User originUser);
}
