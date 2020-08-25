package com.windAndCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Xiongfeng
 * @date 2020/8/25 0025 16:16
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
public class FeignMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain.class,args);
    }
}
