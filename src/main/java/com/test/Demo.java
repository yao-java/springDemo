package com.test;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Author Yao
 * @Description
 * @Date 2022/6/30 14:46
 **/

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.test.mapper"})
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

}
