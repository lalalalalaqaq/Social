package com.edu.social.mapper;

import com.edu.social.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author : orange.Zhang
 * @date : 2022-07-12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void findByAccount(){
        final User user = userMapper.findOneUser("lalalalaqaq");
        System.out.println(user);
    }

}