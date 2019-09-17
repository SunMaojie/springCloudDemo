package jx.demo.springcloud.gateway.common.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * <p>ClassName: RequestTimeFilterFactory</p>
 * <p>Description: 自定义过滤工厂类，可以在配置文件中配置 </p>
 *
 * @author smj
 * @date 2019/3/27
 **/
public class RequestTimeGatewayFilterFactory  extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory .Config> {
    private static final Log log = LogFactory.getLog(RequestTimeGatewayFilterFactory.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    private static final String KEY = "withParams";

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }
//    在类的构造器中一定要调用下父类的构造器把Config类型传过去，否则会报ClassCastException
    public RequestTimeGatewayFilterFactory () {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            //If you want to build a "pre" filter you need to manipulate the
            //request before calling chain.filter
            exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());

            //use builder to manipulate the request
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if (config.isWithParams()) {
                                sb.append(" params:").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }
    /**
     * <p>Title: RequestTimeFilterFactory</p>
     * <p>Description: Put the configuration properties for your filter here,就是配置属性
     * 加了是否打印请求参数的逻辑，而这个逻辑的开关是config.isWithParams()
     * </p>
     *
     * @param []
     * @return
     * @date 2019/3/27
     **/
    public static class Config {

        private boolean withParams;

        public boolean isWithParams() {
            return withParams;
        }

        public void setWithParams(boolean withParams) {
            this.withParams = withParams;
        }

    }
}

