package com.usst.springaop;

import com.usst.springaop.jdk.CGLIBProxy;
import com.usst.springaop.jdk.JDKProxy;
import com.usst.springaop.jdk.UserManager;
import com.usst.springaop.jdk.UserManagerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void jdkProxyTest() {
        System.out.println("--------------JDKProxy--------------");
        JDKProxy jdkProxy = new JDKProxy();
        UserManager userManager = (UserManager) jdkProxy.creatProxy(new UserManagerImpl());
        userManager.addUser("1","snj");
    }

    @Test
    void cjlibProxyTest() {
        System.out.println("--------------CGLIBProxy--------------");
        CGLIBProxy cglibProxy = new CGLIBProxy();
        UserManager userManager = (UserManager) cglibProxy.creatProxy(new UserManagerImpl());
        userManager.addUser("1","snj");
    }
}
