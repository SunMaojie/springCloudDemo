package jx.demo.springcloud.zuul.common.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>ClassName: SystemZuulFilter</p>
 * <p>Description: 利用zuul进行过滤请求 </p>
 *
 * @author smj
 * @date 2019/3/19
 **/
@Component
public class SystemZuulFilter extends ZuulFilter {
    /**
     * <p>Title: filterType</p>
     * <p>Description: 过滤器类型，pre，routing，post，error</p>
     *
     * @param []
     * @return java.lang.String
     * @date 2019/3/19
     **/
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * <p>Title: filterOrder</p>
     * <p>Description: 过滤的顺序</p>
     *
     * @param []
     * @return int
     * @date 2019/3/19
     **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * <p>Title: shouldFilter</p>
     * <p>Description: 这里可以写逻辑判断，是否要过滤，本文true,永远过滤</p>
     *
     * @param []
     * @return boolean
     * @date 2019/3/19
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * <p>Title: run</p>
     * <p>Description: filter逻辑实现类</p>
     *
     * @param []
     * @return java.lang.Object
     * @date 2019/3/19
     **/
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.printf("Zuul 前置路由，获取参数token=%s \n", request.getParameter("token"));
        if (request.getParameter("token") == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
            return null;
        }
        return null;
    }
}
