package com.htgy.service.impl;


import com.htgy.service.ServiceInterface;
import com.htgy.user.User;
import com.htgy.userdao.impl.UserDAOImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("sI")
public class ServiceImpl implements ServiceInterface {
    @Resource
    private UserDAOImpl dao;
    /*登录失败，账号或密码为空
     */

    public HashMap<String, Object> dealNull(){
        HashMap<String, Object> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("账户或者密码不能为空");
        hashMap.put("msg", list);
        return hashMap;
    }

    //登陆失败，账号或者密码错误
    public  HashMap<String, Object> error(){
        HashMap<String, Object> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("账户或者密码错误");
        hashMap.put("msg", list);
        return hashMap;
    }

    //登录成功
    public  HashMap<String, Object> loginSuccess(){
        HashMap<String, Object> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("登录成功");
        hashMap.put("msg", list);
        return hashMap;
    }

    public boolean doquery(String account, String password){
        try{
            System.out.println("this is doquery");
            User user = dao.queryAccount(account);
            System.out.println(user.getAccount()+"  "+user.getPassword());
            if(user.getAccount().equals(account)&&user.getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

}
