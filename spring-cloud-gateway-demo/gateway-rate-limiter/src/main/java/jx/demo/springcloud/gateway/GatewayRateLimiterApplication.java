package jx.demo.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayRateLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayRateLimiterApplication.class, args);
    }

}