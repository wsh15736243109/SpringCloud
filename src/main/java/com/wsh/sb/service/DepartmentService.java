package com.wsh.sb.service;

import com.wsh.sb.dao.DepartmentMapper;
import com.wsh.sb.model.DepartmentModel;
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
