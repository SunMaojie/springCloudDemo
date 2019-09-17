package jx.demo.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
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
public class ConfigController {

    @Value("${foo}")
    private String foo;
    @Value("${password}")
    private String password;
    @Value("${password2}")
    private String password2;

    @RequestMapping(value = "list")
    public String list() {
        return "config foo=" + foo +
                "<br/> config password=" + password +
                "<br/> config password2=" + password2;

    }
}