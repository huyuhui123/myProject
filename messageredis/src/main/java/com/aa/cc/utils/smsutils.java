package com.aa.cc.utils;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;
/**
 * 调用@sendsms直接发
 * 参数：（除去必填的token等）
 * to: 字符串类型，短信接收手机号码集合,用英文逗号分开,如 "13810001000, 最多一次发送200个。
 * templateId: 字符串类型，模板Id,如使用测试模板，模板id为"1"，如使用自己创建的模板，则使用自己创建的短信模板id即可。
 * datas: 字符串数组类型，内容数据，需定义成数组方式，如模板中有两个参数，定义方式为String{"3456"，"测试"}。*/
public class smsutils {

    public void sendsms(String tele,String sms,int timeout){
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "";
        String accountToken = "";
        //请使用管理控制台中已创建应用的APPID
        //测试的话一天只能发给一个手机号一次
        String appId = "";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String to = tele;
        String templateId= "1";
        String[] datas = {sms,String.valueOf(timeout)};
        String subAppend="1234";  //可选	扩展码，四位数字 0~9999
        String reqId="fadfafas";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        //HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas,subAppend,reqId);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }
    }

