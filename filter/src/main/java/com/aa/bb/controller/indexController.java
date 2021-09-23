package com.aa.bb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class indexController {
    @RequestMapping("/")
    public String toindex(){
        return "index";
    }

    @RequestMapping("/main")
    public String tomain(){
        return "main";
    }
    /**
     * 先访问/，不拦截，返回index，
     * 访问main，拦截
     * 访问login，返回session和login，然后访问main就不拦截
     * */
    @RequestMapping("/login")
    public String tologin(HttpServletRequest request){
        request.getSession().setAttribute("user","123");
        return "login";
    }

}
