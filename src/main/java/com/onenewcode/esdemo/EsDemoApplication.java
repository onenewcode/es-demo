package com.onenewcode.esdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author 29071
 * @version 1.0
 * @data 2023/11/19 16:42
 */
@MapperScan("com.onenewcode.esdemo.mapper")
@SpringBootApplication
public class EsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsDemoApplication.class, args);
    }

}
