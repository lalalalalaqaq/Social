package com.edu.social.service.impl;

import com.edu.social.model.entity.User;
import com.edu.social.service.SubscribeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author : orange.Zhang
 * @date : 2022-07-14
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscribeServiceImplTest {

    @Resource
    SubscribeService subscribeService;

    @Test
    public void SaveOneSubscribeMessage(){
        final Boolean aBoolean = subscribeService.Subscribe("q", "z");
        Assert.assertTrue(aBoolean);

    }

    @Test
    public void SaveOneSubscribeMessage_1(){
        final Boolean aBoolean = subscribeService.Subscribe("lala1", "lala2");
        Assert.assertTrue(aBoolean);

    }

    @Test
    public void findUserToFollow(){
        List<User> userList = subscribeService.showSubscribe("Ooorange");
        for (User user : userList){
            System.out.println(user);
        }

    }


    @Test
    public void hash(){
        System.out.println("(\"lala1\" + \"lala3\").hashCode() = " + ("lala1" + "lala3").hashCode());
        System.out.println("(\"lala1\" + \"lala3\").hashCode() = " + ("lala1" + "lala3").hashCode());
        System.out.println("(\"lala1\" + \"lala3\").hashCode() = " + ("lala1" + "lala3").hashCode());
        System.out.println("(\"lala1\" + \"lala3\").hashCode() = " + ("lala1" + "lala3").hashCode());
        System.out.println("(\"lala1\" + \"lala3\").hashCode() = " + ("lala1" + "lala3").hashCode());
    }

}