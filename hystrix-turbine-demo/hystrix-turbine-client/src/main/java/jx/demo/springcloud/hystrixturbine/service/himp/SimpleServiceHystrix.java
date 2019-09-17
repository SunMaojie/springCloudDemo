package jx.demo.springcloud.hystrixturbine.service.himp;

import jx.demo.springcloud.hystrixturbine.service.SimpleService;
import org.springframework.stereotype.Component;

/**
 * <p>ClassName: SimpleServiceHystrixImp</p>
 * <p>Description: 针对Feign的Hystrix断路器实现 </p>
 *
 * @author smj
 * @date 2019/3/18
 **/
@Component
public class SimpleServiceHystrix implements SimpleService {
    @Override
    public String list() {
        return "发生错误，Feign Hystrix！！！";
    }
}
