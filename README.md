# Guice-Jersey-shiro

一个集成了Guice/Jersey/Shiro/Mybatis的RESTful项目

Guice version: 4.2.2

Jersey version: 2.27

Shiro version: 1.4.0

Mybatis version: 3.4.6

Guice-Mybatis version: 3.10


Usage:
```shell
    mvn clean install -Dmaven.test.skip=true
```
打包war, 发布到tomcat


登录REST api: http://127.0.0.1:8080/user/login  POST请求

入参形式:
{
    username: "***",
    password: "***"
}

No Test.

