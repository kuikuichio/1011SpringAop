package com.usst.springaop.jdk;


public class UserManagerImpl  implements  UserManager{
    @Override
    public void delUser(String id) {
        System.out.println(".: 调用了UserManagerImpl.delUser()方法！ ");
    }

    @Override
    public void addUser(String id, String password) {
        System.out.println(".: 调用了UserManagerImpl.addUser()方法！ ");
    }
}
