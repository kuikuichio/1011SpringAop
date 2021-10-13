package com.usst.springaop.jdkproxy;

public class HouseMaster implements HouseManager{
    @Override
    public void saleHouse() {

        System.out.println("我是房屋主人，正准备卖房子！");
    }

    @Override
    public void rentHouse() {
        System.out.println("我是房屋主人，想要将房子出租！");
    }
}
