package com.usst.springaop.jdkproxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        ProxyInvokeHandler proxyInvokeHandler = new ProxyInvokeHandler();
        HouseManager houseManager = (HouseManager) proxyInvokeHandler.creatProxy(new HouseMaster());
        houseManager.rentHouse();

        CglibProxyInterceptor interceptor = new CglibProxyInterceptor();
        HouseManager proxy = (HouseManager) interceptor.createProxy(new HouseMaster());
        proxy.saleHouse();

    }
}
