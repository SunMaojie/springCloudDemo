package jx.demo.srpingcloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: SimpleRestProvider</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/14
 **/
@RestController
@RequestMapping("restProvider")
public class SimpleRestProvider {

    @Value("${server.port}")
    String port;

    @RequestMapping("list")
    public String list() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Eureka ! port is:"+port;
    }
}
