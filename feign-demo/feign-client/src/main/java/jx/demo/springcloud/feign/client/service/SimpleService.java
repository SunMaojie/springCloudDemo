package jx.demo.springcloud.feign.client.service;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>ClassName: SimpleService</p>
 * <p>Description: TODO </p>
 *
 * @author smj
 * @date 2019/3/15
 **/
@FeignClient(value = "CLIENT01")
public interface SimpleService {
    /**
     * <p>Title: list</p>
     * <p>Description: feign的伪客户端</p>
     *
     * @param []
     * @return java.lang.String
     * @date 2019/3/18
     **/
    @RequestMapping(value = "/restProvider/list")
    String list();

    /**
     * <p>Title: listWithQuery</p>
     * <p>Description: 调用rest接口，传递参数</p>
     *
     * @param [name]
     * @return java.lang.String
     * @date 2019/3/18
     **/
    @RequestMapping("/restProvider/list")
    String listWithQuery(@RequestParam("name") String name);

    /**
     * <p>Title: testObj</p>
     * <p>Description: 传递对象参数</p>
     *
     * @param [user]
     * @return java.lang.String
     * @date 2019/3/18
     **/
    @RequestMapping("/testOutObj")
    String testObj(@RequestBody User user);
}
