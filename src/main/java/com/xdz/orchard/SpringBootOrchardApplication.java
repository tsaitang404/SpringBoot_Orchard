package com.xdz.orchard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xdz.orchard.mapper")
public class SpringBootOrchardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOrchardApplication.class, args);
    }

}
