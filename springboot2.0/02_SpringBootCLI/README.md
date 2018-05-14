# 使用SpringBootCLI 2.0 创建项目

## 安装 SpringBoot CLI 2.0
下载cli2.0 
配置环境变量
SPRING_HOME=x:\spring-boot2
PATH=%SPRING_HOME%/bin

验证安装
```
>spring --version 
```

## 使用cli创建项目
```
spring init -dweb,data-jpa,mysql,thymeleaf,jdbc --build gradle CLI_Example
```

## 使用官网生成初始项目并下载
https://start.spring.io/