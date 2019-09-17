package jx.demo.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableHystrix
public class GatewayStatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayStatingApplication.class, args);
    }

    /**
     * <p>Title: myRoutes</p>
     * <p>Description: 使用一个RouteLocatorBuilder的bean去创建路由</p>
     *
     * @param [builder]
     * @return org.springframework.cloud.gateway.route.RouteLocator
     * @date 2019/3/26
     **/
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World")) //filters是各种过滤器，用来对请求做各种判断和修改
                        .uri("http://httpbin.org:80"))
                .build();
    }

    /**
     * <p>Title: myRoutes2</p>
     * <p>Description: 待有hystrix的gateway</p>
     *
     * @param [builder]
     * @return org.springframework.cloud.gateway.route.RouteLocator
     * @date 2019/3/26
     **/
    @Bean
    public RouteLocator myRoutes2(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get2")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }


    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }


}
