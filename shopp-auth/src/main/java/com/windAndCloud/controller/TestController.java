package com.windAndCloud.controller;


import com.winAndCloud.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuxiongfeng
 * @since 2020-09-03
 */
@Controller
@RequestMapping("/Testshopp")
public class TestController {

    @RequestMapping("/testLogin")
    public Result testLogin(String username, String pwd){
        return null;
    }
    @RequestMapping("/testLoginOut")
    public Result testLoginOut(){
        return null;
    }
}

