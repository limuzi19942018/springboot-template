# Springboot基础架构，根据具体情况引用，不需要的可删除

Springboot2+ ，mybatis-plus3+，minio

可以往里面加一些常用的方法，作为Demo项目的基础架构，尽可能的少包含业务，如果有新的Demo，下载本项目，修改项目名及包名，少量的配置，快速个性化开发；

## 1、结构

logs：系统日志

sql：sql文件（创建用户表）

src：java类

## 2、模块划分

base：基础模块；分页，系统参数，返回bean定义等；

config：配置信息；mybitis配置，web配置等；

exception：异常模块；全局处理；

module：业务模块；

utils：工具模块；

## 3、需要修改的地方

1、com.shannonai.springboot.config.MybatisPlusConfig 中需要扫描的类

```java
@EnableTransactionManagement
@Configuration
// 根据实际项目进行修改
@MapperScan(basePackages = {"com.shannonai.springboot.module.*.dao"})
public class MybatisPlusConfig {}
```

2、com.shannonai.springboot.module.system  此模块为样例，可删除

3、application.yml

```yaml
# 数据库连接
datasource:
  username: root
  password: root
  url: jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8
  #mysql8版3本以上指定新的驱动类
  driver-class-name: com.mysql.cj.jdbc.Driver
  #引入Druid数据源
  type: com.alibaba.druid.pool.DruidDataSource
```

```yaml
# mybatis-plus配置
mybatis-plus:
  mapper-locations: classpath*:com/shannonai/springboot/module/**/mapper/*.xml
```

```yaml
minio:
  endpoint: http://39.106.179.25:8095  #已集群，nginx代理
  accessKey: minio
  secretKey: minio123
  bucketName: shannonai-springboot  #需要修改，根据每个项目不同命名
```

