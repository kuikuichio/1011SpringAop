package com.usst.springaop.service.serviceImpl;

import org.springframework.stereotype.Service;

@Service
public class DoServiceImpl {
    public DoServiceImpl() {
        super();
    }

    private String name;

    public DoServiceImpl(String userName) {
        setUserName(userName);
    }

    private void setUserName(String userName) {
        this.name = userName;
    }

    public void add(String userName, String password) {
        this.setUserName(userName);
        System.out.println("要添加的方法" + "用户名" + name + "密码" + password);
    }
}
