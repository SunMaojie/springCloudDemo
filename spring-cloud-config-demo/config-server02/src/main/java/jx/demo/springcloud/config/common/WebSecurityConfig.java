package jx.demo.springcloud.config.common;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>ClassName: SecureConfig</p>
 * <p>Description: Deprecated The security auto-configuration is no longer customizable.
 * Provide your own WebSecurityConfigurer bean instead.
 * 主要配置禁用CSRF保护，无法伪造post请求生成密码
 *
 * </p>
 *
 * @author smj
 * @date 2019/3/22
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * <p>Title: configure</p>
     * <p>Description: Security配置，最基本的登陆认证方式</p>
     *
     * @param [http]
     * @return void
     * @date 2019/3/22
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //禁用CSRF保护
                .csrf().disable()

                .authorizeRequests()
                //所有其他的URL都需要用户进行验证
                .anyRequest().authenticated()
                .and()
                //采用最基本的http验证方式，没有登陆界面，浏览器会弹出一个登录验证的对话框
                .httpBasic();

    }

    /**
     * <p>Title: configure</p>
     * <p>Description:Security规则配置 配置登陆为form</p>
     *
     * @param [http]
     * @return void
     * @date 2019/3/22
     **//*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    //禁用CSRF保护
                .csrf().disable()
                .authorizeRequests()
                //任何人(包括没有经过验证的)都可以访问"resources"、”/signup”和”/about”
                .antMatchers("/resources/**", "/signup", "/about").permitAll()
                // “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                //所有其他的URL都需要用户进行验证
                .anyRequest().authenticated()
                .and()
                //使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证。
                .formLogin()
                ;

    }*/
}
