package com.aa.bb.controller;

import com.aa.bb.dao.lunDao;
import com.aa.bb.dao.userDao;
import com.aa.bb.entity.Lun;
import com.aa.bb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@Controller
public class userAddlunController {
    @Autowired
    public userDao userDao;
    @Autowired
    public lunDao lunDao;

    @RequestMapping("/addlun")
    @ResponseBody
    public boolean addlun(@PathParam("name") String name,
                          @PathParam("content") String content){
        //创建用户，用户名重复重新填
        User user = userDao.findUserByName(name);
        if (user!=null){
            //不能创建用户
            return false;
        }else {
            //创建user，并返回创建的主键
            User user1 = new User(name);
            userDao.insertUser(user1);
            lunDao.insertLun(new Lun(content,user1.getId()));
            return true;
        }
        // System.out.println(name+content);
        //存储评论
    }


}
