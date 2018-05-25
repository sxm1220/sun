package com.sun.feiginInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunxuman
 * @Description:
 * @date 2018/5/22 13:54
 */
@FeignClient(value = "sun-eurekaclient",fallback =SchedualServiceHiHystric.class )
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
