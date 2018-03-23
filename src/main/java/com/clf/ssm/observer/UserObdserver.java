package com.clf.ssm.observer;

import com.yingjun.ssm.entity.Goods;
import com.yingjun.ssm.entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class UserObdserver {

    private User users=new User();

    public abstract void changePrice(Goods goods, float price);

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
