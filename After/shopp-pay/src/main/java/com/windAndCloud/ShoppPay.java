package com.windAndCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Xiongfeng
 * @date 2020/8/25 0025 14:35
 */

@SpringBootApplication
@EnableEurekaClient
public class ShoppPay {
    public static void main(String[] args) {
        SpringApplication.run(ShoppPay.class,args);
    }
}
