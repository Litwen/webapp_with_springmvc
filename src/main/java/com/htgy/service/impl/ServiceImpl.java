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
        String msg = "账户或者密码不能为空";
        hashMap.put("msg", msg);
        return hashMap;
    }

    public HashMap<String, Object> dealRegistNull(){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = "请填写完整的信息";
        hashMap.put("msg", msg);
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

    public HashMap<String, Object> registError(){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = "账户已存在";
        hashMap.put("msg", msg);
        return hashMap;
    }

    public HashMap<String, Object> registPassWordError(){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = "两次密码输入不一致";
        hashMap.put("msg", msg);
        return hashMap;
    }

    public HashMap<String, Object> unkonwError(){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = "抱歉！发生未知错误";
        hashMap.put("msg", msg);
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

    public HashMap<String, Object> registSuccess(){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = "登录成功";
        hashMap.put("msg", msg);
        return hashMap;
    }

    public HashMap<String, Object> getLoginUsername(String account){
        HashMap<String, Object> hashMap = new HashMap<>();
        String msg = null;
        try {
            User user = dao.queryAccount(account);
            msg = user.getUsername();
            hashMap.put("msg", msg);
            return hashMap;
        }catch (Exception e){
            hashMap.put("msg", msg);
            return hashMap;
        }
    }



    public boolean doquery(String account, String password){
        try{
            User user = dao.queryAccount(account);
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



    public boolean checkExist(String account){
        try {
            User user = dao.queryAccount(account);
            if (user.getAccount().equals(account)){
                return true;
            }else return false;
        }catch (Exception e){
            return false;
        }
    }

    public void insert(String username, String account, String password){
        dao.insert(username, account, password);

    }

}
