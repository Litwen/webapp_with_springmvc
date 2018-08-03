package com.htgy.actions;


import com.htgy.form.UserForm;
import com.htgy.service.impl.ServiceImpl;
import com.htgy.view.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class LRController {
    @Resource
    private ServiceImpl sI;
    @Resource
    private View view;

    @RequestMapping({"/","/toLogin"})
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }


    @RequestMapping("/toRegist")
    public ModelAndView toRegist(){
        return new ModelAndView("regist");
    }

    @RequestMapping("/doLogin")
    public ModelAndView doLogin(UserForm userForm){
        String account = userForm.getAccount();
        String password = userForm.getPassword();
        System.out.println(account+"    "+password+"    "+view.getLogin());
        if("".equals(account)||"".equals(password)){
            System.out.println(view.getLogin());
            return new ModelAndView(view.getLogin(), sI.dealNull());
        }else if (sI.doquery(account, password)){
            System.out.println(view.getLoginSucess());
            return new ModelAndView(view.getLoginSucess(), sI.loginSuccess());
        }else{
            System.out.println(view.getLoginSucess());
            return new ModelAndView(view.getLoginFail(), sI.error());
        }
    }



}
