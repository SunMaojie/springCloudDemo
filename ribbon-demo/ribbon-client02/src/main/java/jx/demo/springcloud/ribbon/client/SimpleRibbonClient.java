package jx.demo.springcloud.ribbon.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>ClassName: SimpleRestProvider</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/14
 **/
@Controller
@RequestMapping("ribbonClient")
public class SimpleRibbonClient {

    @Resource
    RestTemplate restTemplate;

    private final static String host = "http://CLIENT01";

    @ResponseBody
    @RequestMapping("list")
    public String list() {
        String rltMsg = restTemplate.getForObject("http://CLIENT01/restProvider/list", String.class);
        System.out.println(rltMsg);
        return rltMsg;
    }
}
