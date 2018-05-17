package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.PersonModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {

    @Autowired
    PersonMapper personMapper;


    @Test
    public void queryTestByName(){
        PersonModel u = personMapper.findByPhone("www");
//        System.out.println("测试查询到  ："+u.toString());
//		Assert.assertEquals(20, u.intValue());
    }
    @Test
    public void getAllPerson() {
        List<PersonModel> personModels = personMapper.getAllPerson();
        System.out.println("查询所有的数据：" + personModels);
    }
}