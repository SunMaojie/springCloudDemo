package jx.demo.springcloud.hystrixdashboard.controller;

import jx.demo.springcloud.hystrixdashboard.service.SimpleRibbonService;
import jx.demo.springcloud.hystrixdashboard.service.SimpleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>ClassName: SimpleRestProvider</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/14
 **/
@RestController
@RequestMapping("hystrix")
public class SimpleHystrixController {


    @Resource
    SimpleService simpleService;
    @Resource
    SimpleRibbonService simpleRibbonService;

    @RequestMapping("list")
    public String list() {
        String rlt = simpleService.list();
        System.out.printf("Feign调用结果：%s \n",rlt);
        return rlt;
    }

    @RequestMapping("list2")
    public String list2() {
        String rlt = simpleRibbonService.list();
        System.out.printf("Ribbon调用结果：%s \n",rlt);
        return rlt;
    }
}
