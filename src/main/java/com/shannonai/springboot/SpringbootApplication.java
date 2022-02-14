package com.shannonai.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 启动类
 * @Description: TODO
 * @Author ligang
 * @Date 2021/7/14 10:53
 */
@SpringBootApplication
@Slf4j
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        log.info("启动成功------------------");
    }

}
