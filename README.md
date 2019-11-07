# bill
This is a Spring Boot project.

bill的文件目录

```
|-- BILL_SQL.sql    ------创建MySQL数据库的sql文件
|-- README.md       ------项目文档
|-- mvnw			------maven文件
|-- mvnw.cmd
|-- pom.xml			------项目包依赖文件
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- application.properties    ------项目配置文件
|   |   |   `-- com
|   |   |       `-- Spring
|   |   |           `-- bill
|   |   |               |-- BillApplication.java      ------spring boot项目启动类
|   |   |               |-- example					  ------项目实列，即项目增删改查的主模块
|   |   |               |   |-- Bill.java
|   |   |               |   |-- BillController.java
|   |   |               |   |-- BillMapper.java
|   |   |               |   `-- BillService.java
|   |   |               |-- login                     ------用户登陆校验模块SpringSecurity
|   |   |               |   |-- CustomUserDetailsService.java
|   |   |               |   |-- Role.java
|   |   |               |   |-- SpringSecurityConf.java
|   |   |               |   |-- User.java
|   |   |               |   |-- UserController.java
|   |   |               |   |-- UserMapper.java
|   |   |               |   |-- UserRole.java
|   |   |               |   |-- UserService.java
|   |   |               |   `-- test.java
|   |   |               `-- register				  ------用户注册模块
|   |   |                   |-- RegisterController.java
|   |   |                   |-- RegisterMapper.java
|   |   |                   `-- RegisterService.java
|   |   `-- resources
|   |       |-- application.properties
|   |       |-- banner.txt				------自定义项目启动的样式
|   |       |-- static
|   |       |   `-- 404page.png			------404静态资源
|   |       `-- templates				------前端资源文件
|   |           |-- edit.html			------编辑页面html
|   |           |-- error				
|   |           |   |-- 404.html
|   |           |   `-- 404page.png
|   |           |-- home.html			------主页html
|   |           |-- list.html			
|   |           |-- login.html
|   |           |-- registerForm.html
|   |           `-- test.html
|   `-- test			------测试模块，还没有写....
|       `-- java
|           `-- com
|               `-- Spring
|                   `-- bill
|                       `-- BillApplicationTests.java
`-- target
    |-- maven-archiver
    |   `-- pom.properties
    |-- maven-status
    |   `-- maven-compiler-plugin
    |       |-- compile
    |       |   `-- default-compile
    |       |       |-- createdFiles.lst
    |       |       `-- inputFiles.lst
    |       `-- testCompile
    |           `-- default-testCompile
    |               |-- createdFiles.lst
    |               `-- inputFiles.lst
    `-- surefire-reports
        |-- TEST-com.Spring.bill.BillApplicationTests.xml
        `-- com.Spring.bill.BillApplicationTests.txt


```

