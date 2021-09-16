package com.aa.bb.controller;

import com.aa.bb.dao.lunDao;
import com.aa.bb.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class indexController {
    @Autowired
    public lunDao lunDao;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("lunsList",lunDao.findAllLun());
        return "index";
    }
}
