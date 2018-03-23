package com.clf.test.ssm.observer;

import com.clf.ssm.observer.GoodsReduce;
import com.clf.ssm.observer.UserObdserver;
import com.clf.ssm.observer.UserPlanGoods;
import com.yingjun.ssm.dao.GoodsDao;
import com.yingjun.ssm.dao.UserDao;
import com.yingjun.ssm.entity.Goods;
import com.yingjun.ssm.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class goodsReduceTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;

    public List<UserObdserver> userObservers=new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        List<User> users = this.userDao.queryAll(0, 3);
        for(User user : users){
            UserObdserver userPlans= new UserPlanGoods();
            userPlans.setUsers(user);
            userObservers.add(userPlans);

        }
    }

    @Test
    public void notifyUsers() {
        List<Goods> goods=this.goodsDao.queryAll(0,5);
        GoodsReduce goodsReduce=new GoodsReduce();
        goodsReduce.setGoods(goods);//降价的商品
        goodsReduce.setUsers(this.userObservers);//购物车中有相关商品的用户
        goodsReduce.notifyUsers();
    }

    @After
    public void release(){
        this.userObservers.clear();
    }
}