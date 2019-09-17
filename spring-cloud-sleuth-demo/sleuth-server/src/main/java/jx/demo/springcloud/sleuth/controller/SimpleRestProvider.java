package jx.demo.springcloud.sleuth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: SimpleRestProvider</p>
 * <p>Description: zipkin服务提供者 </p>
 *
 * @author smj
 * @date 2019/3/25
 **/
@RestController
@RequestMapping("restProvider")
public class SimpleRestProvider {

    @Value("${server.port}")
    String port;

    @RequestMapping("list")
    public String list() {
        return "Hello Eureka ! port is:"+port;
    }
}
