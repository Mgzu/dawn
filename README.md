# Dawn

## 简介

Dawn 是基于 Spring Boot 2.0.3 开发。  
同时集成了 JPA 和 Mybatis，这样做的好处是当进行简单的数据操作时，可以使用 JPA 处理，有利于快速开发，而复杂的数据操作，则可以用 Mybatis 去处理，且可以手动优化 🙃。  
日志使用 logback 实现，保存路径为项目路径下的 log 文件夹。  
banner 由 http://www.network-science.de/ascii 生成。

## 技术选型

|      \       |       框架       | 版本  |
| :----------: | :--------------: | :---: |
|   定时任务   |      quartz      |       |
|  web socket   | spring-websocket |       |
|     日志     |     logback      |       |
| 数据可连接池 |      druid       | 1.1.9 |
|     分页     |    pagehelper    | 1.2.5 |

## 环境

|  \    | 版本 |
| :---: | :--: |
|  JDK  |  8   |
| mysql | 5.7  |

## 运行 Dawn

运行 database 文件夹下的 boot.sql 初始化数据库，默认数据库名为 boot。  
将 application.yml.example 复制一份，修改为 application.yml，将数据库的账号、密码修改为本机的数据库账号、密码。  

## 规约

使用阿里巴巴Java开发规约插件。  

## 前端

使用 bootstrap 3、mdui 编写。

## 注意

* spring-boot-devtools 与 pulllog 功能存在冲突，使用功能时，需要注释或去掉 spring-boot-devtools。  