package com.edu.social.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.social.model.entity.Subscribe;
import com.edu.social.service.SubscribeService;
import com.edu.social.mapper.SubscribeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author 86135
* @description 针对表【subscribe(关注表)】的数据库操作Service实现
* @createDate 2022-07-14 00:09:44
*/
@Service
public class SubscribeServiceImpl extends ServiceImpl<SubscribeMapper, Subscribe>
    implements SubscribeService{

    @Resource
    SubscribeMapper subscribeMapper;


    @Override
    public Boolean SubscribeOne(String beSubUserAccount, String SubUserAccount) {
        Subscribe subscribe = new Subscribe();
        subscribe.setBeSubuser(beSubUserAccount);
        subscribe.setSubuser(SubUserAccount);
        subscribe.setCreatetime(new Date());
        subscribe.setUpdatetime(new Date());
        return this.save(subscribe);
    }

    @Override
    public Integer SubscribeMutil(String beSubUserAccount, List<String> SubUserAccount) {
        return null;
    }
}




