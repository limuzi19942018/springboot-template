package com.shannonai.springboot.module.system.controller;

import com.shannonai.springboot.base.tips.ErrorTip;
import com.shannonai.springboot.base.tips.SuccessTip;
import com.shannonai.springboot.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author yongli
 * @Date 2022/2/10 17:02
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api/testController")
@Slf4j
public class TestController {


    @GetMapping
    @ResponseBody
    public Object execShell() {
        log.info("开始执行shell");
        String str="docker run --name nginx_2022 -p 8048:80 -d nginx:latest";
        Process exec = null;
        try {
            exec = Runtime.getRuntime().exec(new String[] { "sh", "-c",str  });
            boolean alive = exec.isAlive();
            log.info(" alive:{}",alive);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
