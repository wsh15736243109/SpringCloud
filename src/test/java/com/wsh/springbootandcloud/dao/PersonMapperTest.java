package com.wsh.springbootandcloud.dao;

import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.util.Constant;
import com.wsh.springbootandcloud.util.RSAUtil;
import org.json.JSONException;
import org.json.JSONObject;
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
    public void queryTestByName() {
        PersonModel u = personMapper.findByPhone("www");
//        System.out.println("测试查询到  ："+u.toString());
//		Assert.assertEquals(20, u.intValue());
    }

    @Test
    public void getAllPerson() throws Exception {
//        List<PersonModel> personModels = personMapper.getAllPerson();
        // generate public and private keys
//        KeyPair keyPair = buildKeyPair();
//        PublicKey publicKey = keyPair.getPublic();
//        PrivateKey privateKey = keyPair.getPrivate();
////
//        savePrivateKey(privateKey);
//        savePublicKey(publicKey);
        // encrypt the message

        PublicKey publicKey = loadPublicKey(Constant.PUBLIC_KEY);
        PrivateKey privateKey = loadPrivateKey(Constant.PRIVATE_KEY);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("app_type", "android");
            jsonObject.put("phone", "15736243109");
            jsonObject.put("pwd", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        PrivateKey privateKey = RSAUtil.loadPrivateKey(Constant.PRIVATE_KEY);
//        PublicKey publicKey = RSAUtil.loadPublicKey(Constant.PUBLIC_KEY);

        byte[] encrypted = encrypt(privateKey, jsonObject.toString());
        String base64Encode = base64Encode(encrypted);
        System.out.println("getAllPerson encrypt:" + base64Encode);  // <<encrypted message>>KeyPairGenerator
        // decrypt the message
        byte[] secret = decrypt(publicKey, base64Decode(base64Encode));
        System.out.println("getAllPerson decrypt>" + new String(secret, UTF8));     // This is a secret message
    }


}