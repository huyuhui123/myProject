package com.aa.cc.controller;

import com.aa.cc.utils.smsutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;
/**
 * 1.需要事务性
 * */
@Controller
public class indexController {
    @Autowired
    StringRedisTemplate redis;


/**
 * 获取手机号生成验证码，*/
@PostMapping("/sendsms")
@ResponseBody
    public String sendsms(@PathParam("tele") String tele){
    //1.生成随机码
    String  sms;
    int timeout=120;
    sms = String.valueOf((int)(Math.random()*1000000));
    //2.在redis存储手机号和随机码并确认时间
    redis.opsForValue().set(tele,sms);
    redis.expire(tele,timeout, TimeUnit.SECONDS);
    //3.发送
    smsutils smsutils = new smsutils();
    smsutils.sendsms(tele,sms,timeout);
    return "发送成功";
}


}
