package me.musclegeeker.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"me.musclegeeker.springboot"})
public class WebFluxMongoApplication {

    public static void main(String[] args) {
        // 程序启动入口
        SpringApplication.run(WebFluxMongoApplication.class, args);
    }
}
