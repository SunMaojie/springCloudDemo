package jx.demo.springcloud.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard  //表示开启仪表盘功能
@EnableFeignClients


@EnableCircuitBreaker
@EnableTurbine
public class HystrixTurbineClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineClientApplication.class, args);
    }

}
