package com.edu.social.service.impl;

import com.edu.social.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author : orange.Zhang
 * @date : 2022-07-16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void SaveMutilUser(){
        userService.userRegister("lalaqaq","2019310143132","2019310143132");
        userService.userRegister("lala1","2019310143132","2019310143132");
        userService.userRegister("lala2","2019310143132","2019310143132");
        userService.userRegister("lala3","2019310143132","2019310143132");
        userService.userRegister("lala4","2019310143132","2019310143132");
        userService.userRegister("lala5","2019310143132","2019310143132");

    }

}