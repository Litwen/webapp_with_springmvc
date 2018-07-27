package com.htgy.actions;


import com.htgy.loginform.LoginForm;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class LoginAction extends SimpleFormController {
    private String lFailview;
    private String lSuccessView;


    public String getlFailview() {
        return lFailview;
    }

    public void setlFailview(String lFailview) {
        this.lFailview = lFailview;
    }

    public String getlSuccessView() {
        return lSuccessView;
    }

    public void setlSuccessView(String lSuccessView) {
        this.lSuccessView = lSuccessView;
    }


    protected ModelAndView onSubmit(
            HttpServletRequest request,	HttpServletResponse response, Object command,	BindException errors)
            throws Exception{
        LoginForm lf = (LoginForm)command;
        System.out.println(lf.getAccount()+"    "+lf.getPassword());
        if("111111".equals(lf.getAccount()) && "123456".equals(lf.getPassword())){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("LoginForm",lf);
            List<String> msgList = new LinkedList<String>();
            msgList.add("你好，登录成功！");
            map.put("msg",msgList);
            System.out.println("登录成功！");
            return new ModelAndView(this.getlSuccessView(),map);
        }else {
            return new ModelAndView(this.getlFailview());
        }
    }
}
