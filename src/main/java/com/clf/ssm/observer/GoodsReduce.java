package com.clf.ssm.observer;

import com.yingjun.ssm.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsReduce {

    private List<UserObdserver> users=new ArrayList<UserObdserver>();
    private List<Goods> Goods=new ArrayList<Goods>();

    public void notifyUsers (){
            for(UserObdserver user : users){
                System.out.println("尊敬的用户："+user.getUsers().getUserName()+" 您好！\n" +
                        "************** 如下商品优惠了 **************");
                for( Goods good :Goods){
                    user.changePrice(good,10);
                }

            }
    }

    public List<UserObdserver> getUsers() {
        return users;
    }

    public void setUsers(List<UserObdserver> users) {
        this.users = users;
    }

    public List<Goods> getGoods() {
        return Goods;
    }

    public void setGoods(List<Goods> goods) {
        Goods = goods;
    }
}
