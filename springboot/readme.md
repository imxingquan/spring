
1. 使用Spring Boot CLI 创建引用程序   
spring init -dweb,data-jpa,h2,thymeleaf --build gradle  readinglist

2. 构建并应用程序  
    gradle bootRun
  构建然后命令行运行
    gradle build
    java -jar build/libs/reading-0.0.1-SNAPSHOT.jar

3. 创建com.example.readinglist.Book 类
4. 创建ReadListResponsitory接口
5. 创建ReadingListController类
6. 创建resource\template\readinglist.html thymeleft模板文件
7. 创建resources\static\style.css
8. 构建并运行 gradle bootRun

