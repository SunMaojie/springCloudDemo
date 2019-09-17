package jx.demo.springcloud.gateway.common.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>ClassName: RequestTimeFilter</p>
 * <p>Description: 自定义Spring Cloud Gateway filter，测试 </p>
 *
 * @author smj
 * @date 2019/3/27
 **/
public class RequestTimeFilter implements GatewayFilter, Ordered {
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    private static final Log log = LogFactory.getLog(RequestTimeFilter.class);

    /**
     * <p>Title: filter</p>
     * <p>Description: 目标记录请求耗时多久，并输出到控制台</p>
     *
     * @param [exchange, chain]
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @date 2019/3/27
     **/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//      pre  先记录了请求的开始时间，并保存在ServerWebExchange中，此处是一个“pre”类型的过滤器
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());

//      post 后再chain.filter的内部类中的run()方法中相当于"post"过滤器
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    //    给过滤器设定优先级别的，值越大则优先级越低
    @Override
    public int getOrder() {
        return 0;
    }
}
