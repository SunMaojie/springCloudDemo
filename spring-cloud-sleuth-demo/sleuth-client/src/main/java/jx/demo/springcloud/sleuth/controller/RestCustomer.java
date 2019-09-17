package jx.demo.springcloud.sleuth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>ClassName: SimpleRestProvider</p>
 * <p>Description: 服务消费者</p>
 *
 * @author smj
 * @date 2019/3/25
 **/
@RestController
@RequestMapping("restCustomer")
public class RestCustomer {
    @Resource
    RestTemplate restTemplate;

    private final static String host = "http://SLEUTH-SERVER";

    @ResponseBody
    @RequestMapping("list")
    public String list() {
        String rltMsg = restTemplate.getForObject(host+"/restProvider/list", String.class);
        System.out.println(rltMsg);
        return rltMsg;
    }
}
