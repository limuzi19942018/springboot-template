package com.shannonai.springboot.config;

import com.shannonai.springboot.properties.MinioProp;
import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 初始化minio客户端
 * @author ligang
 * @date: 2021/8/4 14:04
 */
@Data
@Configuration
public class MinioConfig {

   @Autowired
   private MinioProp minioProp;

    @Bean
    public MinioClient getMinioClient() throws Exception {
        MinioClient minioClient = new MinioClient(minioProp.getEndpoint(), minioProp.getAccessKey(), minioProp.getSecretKey());
        return minioClient;
    }

}
