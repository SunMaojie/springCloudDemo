package jx.demo.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>ClassName: ConfigController</p>
 * <p>Description: 从配置中心读取配置 </p>
 *
 * @author smj
 * @date 2019/3/19
 **/
@RestController
@RequestMapping(value = "config")
@RefreshScope //该注解表明该配置会自动刷新
public class ConfigController {

    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "list")
    public String list() {
        return "config foo=" + foo;
    }
}
