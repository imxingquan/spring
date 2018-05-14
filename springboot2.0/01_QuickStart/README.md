# 使用Gradle插件创建SpringBoot项目

## 创建项目  
```cmd
QuickStart>gradle init --type java-application
```

## 导入依赖
```java
plugins {
    id 'org.springframework.boot' version '2.0.2.RELEASE'
    id 'java'
}

apply plugin: 'io.spring.dependency-management'

jar {
    baseName = 'QuickStart'
    version =  '0.0.1-SNAPSHOT'
}

repositories {
    jcenter()
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

```

##使用gradle或gradlew运行
>gradle bootRun
