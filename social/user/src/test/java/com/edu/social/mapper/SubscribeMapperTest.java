package com.edu.social.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : orange.Zhang
 * @date : 2022-07-16
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscribeMapperTest {

    @Resource
    SubscribeMapper subscribeMapper;

    @Test
    public void testDel(){
        final Integer integer = subscribeMapper.updateSubrelation(("lala1" + "lala3").hashCode());
        System.out.println(integer);
    }


    @Test
    public void selectBeSub(){
        List<String> besublist = subscribeMapper.findRelation("lala2");
        for (String s : besublist){
            System.out.println(s);
        }
    }

}