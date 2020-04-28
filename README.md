# 账单
## 项目简介

初学Spring Boot 的一个小Demo ,基本上完成了账单的增删改查，用户的注册登录，以及用户角色的鉴权

该项目的前端UI主要由`Bootstrap`来实现，数据库操作使用了`mybatis `

## 项目环境要求

+ `Java JDK1.8+`
+ `MySQL5.7+`

## 截图

+ 首页

  ![首页](/img/1.png)

+ 注册页面

  ![注册页](/img/2.png)

+ 登录后的页面

  ![登录后](/img/3.png)

+ 账单页

  ![账单](/img/4.png)

+ 添加账单

  ![添加](/img/5.png)

## 快速开始

> 确认Java和MySQL的版本

```bash
# clone github库
git clone https://github.com/Code-wy/bill.git
```

```bash
# 进入MySQL命令行
mysql> source `文件所在目录`\BILL_SQL.sql
# 例如
mysql> source D:\bill\BILL_SQL.sql
```

```properties
# 进入\src\main\java目录下修改MySQL用户名和密码就可以启动了
spring.datasource.username=你的用户名
spring.datasource.password=你的密码
```

+ 项目初始化管理员用户	用户名：admin	密码：123

## bill的文件目录

```
|-- BILL_SQL.sql    								  ------创建MySQL数据库的sql文件
|-- README.md       								  ------项目文档
|-- mvnw											  ------maven文件
|-- mvnw.cmd
|-- pom.xml											  ------项目包依赖文件
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- application.properties    			  ------项目配置文件
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
|   |       |-- banner.txt							  ------自定义项目启动的样式
|   |       |-- static
|   |       |   `-- 404page.png						  ------404静态资源
|   |       `-- templates							  ------前端资源文件
|   |           |-- edit.html						  ------编辑页面html
|   |           |-- error				
|   |           |   |-- 404.html
|   |           |   `-- 404page.png
|   |           |-- home.html						  ------主页html
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


```

## TODO

- [x] 账单的增删改查
- [x] 用户的注册和登录
- [x] 用户的鉴权
- [ ] . . . .