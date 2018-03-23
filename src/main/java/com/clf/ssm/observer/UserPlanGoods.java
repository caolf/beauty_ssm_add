package com.clf.ssm.observer;

import com.yingjun.ssm.entity.Goods;
import com.yingjun.ssm.entity.User;

public class UserPlanGoods extends UserObdserver {

    @Override
    public void changePrice(Goods goods,float price) {
        System.out.println("用户："+this.getUsers().getUserName()+"  "+"商品："+goods.getTitle()+" 原价："+goods.getPrice()+"  现价："+(goods.getPrice()-price));
    }

}
