package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.PersonModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

import static com.wsh.springbootandcloud.util.RSAUtil.*;

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
    public void getAllPerson() throws Exception{
//        List<PersonModel> personModels = personMapper.getAllPerson();
        // generate public and private keys
        KeyPair keyPair = buildKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // encrypt the message
        byte [] encrypted = encrypt(privateKey, "This is a secret message");
        System.out.println("getAllPerson encrypt:"+base64Encode(encrypted));  // <<encrypted message>>

        // decrypt the message
        byte[] secret = decrypt(publicKey, encrypted);
        System.out.println("getAllPerson decrypt>"+new String(secret, UTF8));     // This is a secret message
    }
}