package com.yf.garden.bs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yf.garden.*"})
@MapperScan(basePackages = "com.yf.garden.bs.dao.*")
public class BigScreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigScreenApplication.class, args);
    }

}
