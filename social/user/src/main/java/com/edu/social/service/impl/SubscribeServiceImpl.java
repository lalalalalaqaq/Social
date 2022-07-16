package com.edu.social.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.social.mapper.UserMapper;
import com.edu.social.model.entity.Subscribe;
import com.edu.social.model.entity.User;
import com.edu.social.service.SubscribeService;
import com.edu.social.mapper.SubscribeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    UserMapper userMapper;


    @Override
    public Boolean Subscribe(String SubUserAccount, String beSubUserAccount) {
        return SubscribeMutil(SubUserAccount,beSubUserAccount);
    }

    @Override
    public Boolean SubscribeMutil(String SubUserAccount, String... beSubUserAccount) {

        if (userMapper.findOneByAccount(SubUserAccount) != 1){
            return false;
        }
        for (String beSub : beSubUserAccount){
            // 真关系（ return ture ）继续运行
            if (!checkRelation(SubUserAccount, beSub)){
                return false;
            }
        }

        List<Subscribe> subscribeList = new ArrayList<>();
        for (String beSub : beSubUserAccount){
            Subscribe subscribe = new Subscribe();
            subscribe.setId((beSub + SubUserAccount).hashCode());
            subscribe.setBeSubuser(beSub);
            subscribe.setSubuser(SubUserAccount);
            subscribe.setCreatetime(new Date());
            subscribe.setUpdatetime(new Date());
            subscribeList.add(subscribe);
        }
        return this.saveBatch(subscribeList);
    }

    @Override
    public Boolean delSubscribe(String beSubUserAccount, String SubUserAccount) {
        return delSubscribeMutil(beSubUserAccount,SubUserAccount);
    }

    @Override
    public Boolean delSubscribeMutil(String SubUserAccount, String... beSubUserAccount) {
        for (String beSub: beSubUserAccount){
            if(checkRelation(beSub, SubUserAccount)){
                subscribeMapper.updateSubrelation((beSub + SubUserAccount).hashCode());
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<User> showSubscribe(String SubUserAccount) {
        List<String> beSubAcc = subscribeMapper.findRelation(SubUserAccount);
        ArrayList<User> userArrayList = new ArrayList<>();
        for (String beSub : beSubAcc){
            User user = userMapper.findOneUser(beSub);
            userArrayList.add(user);
        }

        return userArrayList;
    }


    private Boolean checkRelation(String beSubUserAccount, String sub){
        Integer acc1 = userMapper.findOneByAccount(beSubUserAccount);
        Integer acc2 = userMapper.findOneByAccount(sub);
        Integer subrelation = subscribeMapper.findSubrelation((sub + beSubUserAccount).hashCode());
        if(acc1 == 1 && acc2 == 1 && subrelation == 0){
            return true;
        }
        return false;
    }


}




