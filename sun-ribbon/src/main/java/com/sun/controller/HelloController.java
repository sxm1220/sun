package com.sun.controller;

import com.sun.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxuman
 * @Description:
 * @date 2018/5/22 10:51
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/test")
    public String test(@RequestParam String name){
        return "123";
    }

}
