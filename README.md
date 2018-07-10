# Dawn

## 简介

Dawn 是基于 Spring Boot 2 开发。  
Dawn 同时集成了 JPA 和 Mybatis，这样做的好处是当使用简单的数据操作时，可以使用 JPA，而复杂的 数据操作，则可以用 Mybatis 去处理，并进行手动优化 🙃。  
日志使用 logback 实现，保存路径为项目路径下的 log 文件夹。

## 技术选型

|      \       |       框架       | 版本  |
| :----------: | :--------------: | :---: |
|   定时任务   |      quartz      |       |
|  webscoket   | Spring-webscoket |       |
|     日志     |     logback      |       |
| 数据可连接池 |      druid       | 1.1.9 |
|     分页     |    pagehelper    | 1.2.5 |

## 环境

|  \    | 版本 |
| :---: | :--: |
|  JDK  |  8   |
| mysql | 5.7  |

## 运行

运行 database 文件夹下的 boot.sql 初始化数据库。  
将 application.yml.example 复制一份，修改为 application.yml，并将数据库的账号、密码修改为本机的数据库账号、密码。  
banner 由 http://www.network-science.de/ascii 生成。

## 规范

controller.rest 包下为 restful 风格的 controller。返回类型为 RestDto，自动转换为 json。  
controller.view 包下为控制页面跳转的 controller，返回类型为 ModelAndView。  
controller.ws 包下为 web socket 返回数据的 controller。返回类型不限，自动转换为 json。  
repository 包下为 JPA 的 repository。注入时，XxxRepository 写为 xxxDao。  
mapper 包下为 Mybatis 的 mapper。注入时，XxxMapper 写为 xxxMapper。  
entity 包下为实体类，当用到 JPA 时，需要进行一定的修改。  

## 前端

使用 bootstrap 3、mdui 编写。

## 现有问题

暂无
