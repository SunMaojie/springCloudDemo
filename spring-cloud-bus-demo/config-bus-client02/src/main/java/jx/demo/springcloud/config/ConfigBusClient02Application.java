package jx.demo.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ConfigBusClient02Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigBusClient02Application.class, args);
    }

}
