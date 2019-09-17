package jx.demo.springcloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>ClassName: RestConfig</p>
 * <p>Description: Ribbon配置 </p>
 *
 * @author smj
 * @date 2019/3/15
 **/
@Configuration
public class RestConfig {
    /**
     * <p>Title: restTemplate</p>
     * <p>Description: 注入RestTemplate，并开启负载均衡</p>
     *
     * @param []
     * @return org.springframework.web.client.RestTemplate
     * @date 2019/3/15
     **/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * <p>Title: ribbonRule</p>
     * <p>Description: ribbon负载均衡策略，默认轮询 RoundRobinRule</p>
     *
     * @param []
     * @return com.netflix.loadbalancer.IRule
     * @date 2019/3/15
     **/
    @Bean
    public IRule ribbonRule() {
        //随机负载
        return new RandomRule();
        //根据响应时间分配一个weight(权重)
//        return new WeightedResponseTimeRule();
    }
}
