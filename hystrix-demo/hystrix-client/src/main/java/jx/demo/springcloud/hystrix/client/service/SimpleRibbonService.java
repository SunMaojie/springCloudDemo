package jx.demo.springcloud.hystrix.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>ClassName: SimpleRibbonService</p>
 * <p>Description: 通过Ribbon实现Rest调用，并实现断路器 </p>
 *
 * @author smj
 * @date 2019/3/18
 **/
@Component
public class SimpleRibbonService {
    @Resource
    RestTemplate restTemplate;
    private final static String host = "http://CLIENT01";

    @HystrixCommand(fallbackMethod = "hasErro")
    public String list() {
        String rlt = restTemplate.getForObject(host + "/restProvider/list", String.class);
        return rlt;
    }

    public String hasErro(){
        return "Ribbon发生错误，Hystrix！！！";
    }
}
