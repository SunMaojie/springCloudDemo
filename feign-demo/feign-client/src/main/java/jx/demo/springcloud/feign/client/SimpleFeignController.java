package jx.demo.springcloud.feign.client;

import jx.demo.springcloud.feign.client.service.SimpleService;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("feign")
public class SimpleFeignController {


    @Resource
    SimpleService simpleService;

    @RequestMapping("list")
    public String list() {
        String rlt = simpleService.list();
        System.out.printf("Feign调用结果：%s \n",rlt);
        return rlt;
    }
}
