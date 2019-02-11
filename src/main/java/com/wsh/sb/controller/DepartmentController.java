package com.wsh.sb.controller;

import com.wsh.sb.model.DepartmentModel;
import com.wsh.sb.model.ResultEntity;
import com.wsh.sb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

