package com.htgy.actions;

import com.htgy.registform.RegistForm;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RegistAction {
    private String rFailView;
    private String rSuccessView;

    public String getrFailView() {
        return rFailView;
    }

    public void setrFailView(String rFailView) {
        this.rFailView = rFailView;
    }

    public String getrSuccessView() {
        return rSuccessView;
    }

    public void setrSuccessView(String rSuccessView) {
        this.rSuccessView = rSuccessView;
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
                                    Object command, BindException errors)
        throws Exception{
        System.out.println("This is RegistAction");
        RegistForm rf = (RegistForm)command;
        System.out.println(rf.getAccount()+"    "+rf.getPassFirst());
        if (rf.getAccount().equals("111111") && rf.getPassFirst().equals("123456")
                && rf.getPassSecond().equals("123456")){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("LoginForm", rf);
            List<String> msgList = new LinkedList<String>();
            msgList.add("你好，登录成功！");
            map.put("msg", msgList);
            return new ModelAndView(this.getrSuccessView(), map);
        }else {
            return new ModelAndView(this.getrFailView());
        }

    }
}
