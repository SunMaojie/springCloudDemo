package jx.demo.springcloud.gateway.common.config;

import jx.demo.springcloud.gateway.common.filter.GlobalTokenFilter;
import jx.demo.springcloud.gateway.common.filter.RequestTimeFilter;
import jx.demo.springcloud.gateway.common.filter.RequestTimeGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>ClassName: RouteLocatorConfig</p>
 * <p>Description: 自定义过滤器注册方法 </p>
 *
 * @author smj
 * @date 2019/3/27
 **/
@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                //匹配的路径,主要不要呗application.yml中的配置覆盖
                .route(r -> r.path("/customer/**")
                        //注册过滤器
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        //最终的地址
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }

    /**
     * <p>Title: elapsedGatewayFilterFactory</p>
     * <p>Description: 将自定义的过滤器工厂注入到spring</p>
     *
     * @param []
     * @return jx.demo.springcloud.gateway.common.filter.RequestTimeFilterFactory
     * @date 2019/3/27
     **/
    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    /**
     * <p>Title: globalTokenFilter</p>
     * <p>Description: 注入全局过滤器</p>
     *
     * @param []
     * @return jx.demo.springcloud.gateway.common.filter.GlobalTokenFilter
     * @date 2019/3/27
     **/
    @Bean
    public GlobalTokenFilter globalTokenFilter() {
        return new GlobalTokenFilter();
    }
}
