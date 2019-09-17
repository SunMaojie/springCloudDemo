package jx.demo.springcloud.sleuth.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>ClassName: RestConfig</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/15
 **/
@Configuration
public class RestConfig {
    /**
     *<p>Title: restTemplate</p>
     *<p>Description: 注入RestTemplate，并开启负载均衡</p>
     * @date 2019/3/15
     * @param []
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
