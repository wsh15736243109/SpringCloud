package com.wsh.springbootandcloud.controller;

import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PeronController {

    @Autowired
    PersonMapper personMapper;

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public String getPersonAll(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("list", personMapper.getAllPerson());
        return "PersonHtml";
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
