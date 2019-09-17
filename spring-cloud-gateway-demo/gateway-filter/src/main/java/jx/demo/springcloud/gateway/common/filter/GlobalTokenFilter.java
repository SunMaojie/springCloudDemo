package jx.demo.springcloud.gateway.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>ClassName: GlobalTokenFilter</p>
 * <p>Description: 全局过滤器，不需要在配置文件中配置，作用在所有的路由上 </p>
 *
 * @author smj
 * @date 2019/3/27
 **/
public class GlobalTokenFilter implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(GlobalTokenFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            logger.info("token is empty...");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
