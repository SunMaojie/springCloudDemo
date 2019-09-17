package jx.demo.springcloud.gateway.common.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>ClassName: HostAddrKeyResolver</p>
 * <p>Description: 限流具体实现类</p>
 *
 * @author smj
 * @date 2019/3/27
 **/
public class HostAddrKeyResolver implements KeyResolver {
    /**
     * <p>Title: resolve</p>
     * <p>Description: KeyResolver需要实现resolve方法，比如根据Hostname进行限流，则需要用hostAddress去判断。
     * 实现完KeyResolver之后，需要将这个类的Bean注册到Ioc容器中。</p>
     *
     * @param [exchange]
     * @return reactor.core.publisher.Mono<java.lang.String>
     * @date 2019/3/27
     **/
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}



