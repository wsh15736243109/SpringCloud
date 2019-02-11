package com.wsh.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author:Create by Mr.w
 * @Date:2018/10/20 14:19
 * @Description:
 */
@Controller
public class Index extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
