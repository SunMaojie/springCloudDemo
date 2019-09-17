package jx.demo.springcloud.hystrix.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jx.demo.springcloud.hystrix.client.service.himp.SimpleServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>ClassName: SimpleService</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/15
 **/
@FeignClient(value = "CLIENT01", fallback = SimpleServiceHystrix.class)
public interface SimpleService {
    /**
     * <p>Title: list</p>
     * <p>Description: feign的伪客户端</p>
     *
     * @param []
     * @return java.lang.String
     * @date 2019/3/18
     **/
    @RequestMapping(value = "/restProvider/list")
    String list();

}
