package com.edu.social.service.impl;

import com.edu.social.service.SubscribeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
        final Boolean aBoolean = subscribeService.SubscribeOne("q", "z");
        Assert.assertTrue(aBoolean);

    }

}