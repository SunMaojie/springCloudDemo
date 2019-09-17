package jx.demo.springcloud.gateway.common.config;

import jx.demo.springcloud.gateway.common.filter.HostAddrKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>ClassName: FilterConfig</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/27
 **/
@Configuration
public class FilterConfig {
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

}
