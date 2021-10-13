package com.usst.springaop.controller;

import com.usst.springaop.service.serviceImpl.DoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/DoController")
public class DoController {
    public static final String USERNAME = "XIAOLI";

    @Resource
    public DoServiceImpl doService;

    @RequestMapping("/setUserName")
    public String setUserName(@RequestParam("username") String username,
                              @RequestParam("password")String password){
        doService.add(username,password);
        return "成功";
    }
}
