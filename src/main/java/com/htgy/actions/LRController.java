package com.htgy.actions;


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

    @RequestMapping("toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }


    @RequestMapping({"/","toRegist"})
    public ModelAndView toRegist(){
        return new ModelAndView("regist");
    }
}
