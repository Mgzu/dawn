# Dawn

## 简介

Dawn 是基于 Spring Boot 2 开发。  
项目集成了 JPA 和 Mybatis，这样做的好处是当我们使用简单的 sql 操作时，可以使用 JPA 提供的模板，而复杂的 sql 则用 Mybatis 去处理。  
日志使用 logback 实现，保存路径为项目路径下的 log 文件夹。

## 运行

运行 database 文件夹下的 boot.sql 初始化数据库。  
将 application.yml.example 复制一份，修改为 application.yml，并将数据库的账号、密码修改为本机的数据库账号、密码。  
banner 由 http://www.network-science.de/ascii 生成。

## 所用技术

|      \       |       框架       | 版本  |
| :----------: | :--------------: | :---: |
|   定时任务   |      quartz      |       |
|  webscoket   | Spring-webscoket |       |
|     日志     |     logback      |       |
| 数据可连接池 |      druid       | 1.1.9 |

## 规范

rest 包下为 restful 风格的 controller。返回类型为 json。  
view 包下为控制页面跳转的 controller，返回类型为 ModelAndView。  
repository 包下为 JPA 的 repository。注入时，XXXRepository 写为 xXXDao。  
Mapper 包下为 Mybatis 的 mapper。注入时，XXXMapper 写为 xXXMapper。

## 前端

使用 bootstrap 3、mdui 编写。

## TODO

- [ ] 持续优化系统。
- [ ] 去除 JPA 的 findAll() 方法中不需要的字段，如 PassWord 字段。
