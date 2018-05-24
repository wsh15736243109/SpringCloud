package com.wsh.springbootandcloud.service;

import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeronService {

    @Autowired
    PersonMapper personMapper;

    public ResultEntity userLogin(String phone, String pwd) {
        if (phone == null || "".equals(phone)) {
            new InvalidArgumentException(-1, "invalid phone parameter");
        }
        if (pwd == null || "".equals(pwd)) {
            new InvalidArgumentException(-1, "invalid pwd parameter");
        }
        PersonModel model = personMapper.findByPhone(phone);
        return ResultUtil.successR("操作成功",model);
    }

    public void getPersonAll() {

    }

    public void deletePersonById(String id) {

    }

    public void addPerson(PersonModel personModel) {

    }

    public void updatePerson(PersonModel personModel) {

    }

    public void getPersonById(String id) {

    }
}
