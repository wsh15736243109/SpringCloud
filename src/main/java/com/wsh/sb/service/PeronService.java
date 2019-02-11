package com.wsh.sb.service;

import com.wsh.sb.dao.PersonMapper;
import com.wsh.sb.exception.InvalidArgumentException;
import com.wsh.sb.model.PersonModel;
import com.wsh.sb.model.ResultEntity;
import com.wsh.sb.util.ResultUtil;
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
