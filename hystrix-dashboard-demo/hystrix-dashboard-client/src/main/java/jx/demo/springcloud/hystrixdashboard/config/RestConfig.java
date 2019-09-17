package jx.demo.springcloud.hystrixdashboard.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>ClassName: RestConfig</p>
 * <p>Description: Ribbon配置 </p>
 *
 * @author smj
 * @date 2019/3/18
 **/
@Configuration
public class RestConfig {
    /**
     * <p>Title: restTemplate</p>
     * <p>Description: 注入RestTemplate，并开启负载均衡</p>
     *
     * @param []
     * @return org.springframework.web.controller.RestTemplate
     * @date 2019/3/18
     **/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
