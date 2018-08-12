package com.htgy.actions;


import com.htgy.form.UserForm;
import com.htgy.registform.RegistForm;
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
        if("".equals(account)||"".equals(password)){
            return new ModelAndView(view.getLoginFail(), sI.dealNull());
        }else if (sI.doquery(account, password)){
            return new ModelAndView(view.getLoginSucess(), sI.getLoginUsername(account));
        }else{
            return new ModelAndView(view.getLoginFail(), sI.error());
        }
    }

    @RequestMapping("/doRegist")
    public ModelAndView doRegist(RegistForm registForm){
        String username = registForm.getUsername();
        String account = registForm.getAccount();
        String passFirst = registForm.getPassFirst();
        String passSecond = registForm.getPassSecond();
        System.out.println(username);
        if ("".equals(username)||"".equals(account)||"".equals(passFirst)||"".equals(passSecond)){
            return new ModelAndView(view.getRegistFail(), sI.dealRegistNull());
        }else if(sI.checkExist(account)){
            return new ModelAndView(view.getRegistFail(), sI.registError());
        }else if(sI.checkExist(account) != true && !passFirst.equals(passSecond)){
            return new ModelAndView(view.getRegistFail(), sI.registPassWordError());
        }else{
            try{
                sI.insert(username, account, passFirst);
                return new ModelAndView(view.getRegistSuccess(), sI.registSuccess());
            }catch (Exception e){
                return new ModelAndView(view.getRegistFail(), sI.unkonwError());
            }
        }


    }


}
