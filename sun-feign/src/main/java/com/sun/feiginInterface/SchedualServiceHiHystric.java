package com.sun.feiginInterface;

import org.springframework.stereotype.Component;

/**
 * @author sunxuman
 * @Description:
 * @date 2018/5/22 14:24
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
         return "sorry "+name;
    }
}
