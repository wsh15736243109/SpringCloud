package com.wsh.springbootandcloud.controller;

import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.model.DepartmentModel;
import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.service.DepartmentService;
import com.wsh.springbootandcloud.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/get_all_department")
    @ResponseBody
    public ResultEntity getAllDepartment() {
        List<DepartmentModel> list = departmentService.getAllDepartment();
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setData(list);
        return resultEntity;
    }

}

