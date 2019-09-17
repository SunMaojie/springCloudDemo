package jx.demo.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer02Application.class, args);
    }

}
