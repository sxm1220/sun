package com.sun.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunxuman
 * @Description:1
 * @date 2018/5/22 10:43
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiServiceError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SUN-EUREKACLIENT/hi?name="+name,String.class);
    }

    public String hiServiceError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
