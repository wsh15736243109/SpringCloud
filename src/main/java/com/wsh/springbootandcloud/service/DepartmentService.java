package com.wsh.springbootandcloud.service;

import com.wsh.springbootandcloud.dao.DepartmentMapper;
import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper personMapper;


    public List<DepartmentModel> getAllDepartment() {
        return personMapper.getAllDepartment();
    }
}
