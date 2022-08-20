

# 商业银行信用卡风险管理系统
这是一个商业银行信用卡风险管理系统
主要包括：登录管理，权限管理，客户管理和信用卡管理




###### 开发前的配置要求


1. Windows 10环境
2. IDEA / Shell 开发工具
3. Java JDK 1.8 

###### **项目接口**

**该项目已经在Tomcat服务器上部署，并使用Nginx代理到本站的二级域名**

下面的链接可以看到该项目的SwaggerAPI

[work.chaossnow.com](https://work.chaossnow.com/swagger-ui.html)


**该项目位于Github上的源代码**



```sh
git clone https://github.com/chaospyc/Credit-Card-Risk.git
```

### 文件目录说明
eg:

```
filetree                         
├─msys-master
│  │  pom.xml 
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─chaossnow
│  │  │  │          └─ms
│  │  │  │              ├─controller
│  │  │  │              ├─dao
│  │  │  │              ├─dto
│  │  │  │              │  └─impl
│  │  │  │              ├─pojo
│  │  │  │              ├─result
│  │  │  │              ├─service
│  │  │  │              │  └─impl
│  │  │  │              ├─shiro
│  │  │  │              ├─swagger
│  │  │  │              └─util             
│  │  │  ├─resources
│  │  │  │  └─mappers
│  │  │  └─webapp
│  │  │      └─WEB-INF
│  │  └─test
│  │      └─java
│  └─target  
└─out

```

![应用架构.svg](https://cdn.nlark.com/yuque/0/2022/svg/27863679/1661001951759-7495cf70-54ed-4327-a39c-a5ceded1f03e.svg#clientId=u368c56c8-99ec-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=uc6ad971b&margin=%5Bobject%20Object%5D&name=%E5%BA%94%E7%94%A8%E6%9E%B6%E6%9E%84.svg&originHeight=688&originWidth=783&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17199&status=done&style=none&taskId=u27f670fc-dfa4-4c39-a424-13b30a3f123&title=)

![技术架构 (1).svg](https://cdn.nlark.com/yuque/0/2022/svg/27863679/1661002039173-df8f38c6-3675-4205-b5ef-09f6c870514f.svg#clientId=u2ed616e8-8474-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=ue805a49e&margin=%5Bobject%20Object%5D&name=%E6%8A%80%E6%9C%AF%E6%9E%B6%E6%9E%84%20%281%29.svg&originHeight=758&originWidth=837&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24237&status=done&style=none&taskId=u5795aae5-ef65-4ec7-a3f6-dd32db9c974&title=)

![Diagram 1.svg](https://cdn.nlark.com/yuque/0/2022/svg/27863679/1661002686763-e3e1a882-52a5-4488-ab44-56b57245b174.svg#clientId=u2ed616e8-8474-4&crop=0&crop=0&crop=1&crop=1&from=drop&id=u7e2cad18&margin=%5Bobject%20Object%5D&name=Diagram%201.svg&originHeight=2257&originWidth=1573&originalType=binary&ratio=1&rotation=0&showTitle=false&size=146493&status=done&style=none&taskId=ue2122289-f448-446e-ab48-04d74ae788e&title=)



### 项目效率优化亮点

- 模型层分为DO（Data Object）此对象与数据库表结构一一对应，DTO（Data Transfer Object）：数据传输对象和VO三类数据模型
- 数据库设计中未设置任何外键，查询结构全部使用单表查询，未使用任何级联查询，有数据显示这有助于提升数据库效率
- 数据库中所得货币单位均使用人民币最小单位分，避免了浮点数存储空间大和精度缺失的问题
- 在表查询中，均使用具体字段进行查询，降低了查询分析器解析成本，降低了无用字段对网络的消耗
- 所有数据库字段与DO类均定义了resultMap实现了字段与DO层解耦，数据库中布尔属性均采用is_XXX来命名
- 对用户请求传入的所有参数都进行严格的有效校验，防止出现安全问题，如page size过大导致内存溢出，SQL注入


### 使用到的框架

- Maven
- Spring（IOC DI AOP 声明式事务处理）
- SpringMVC（支持Restful风格）
- Mybatis（半自动持久层管理方案）
- Hibernate Validator（参数校验）
- shiro权限控制 (url控制和菜单双控制)
- Druid（数据源配置 sql防注入 sql性能监控)

### 贡献者

请阅读**CONTRIBUTING.md** 查阅为该项目做出贡献的开发者。

#### 如何参与开源项目

贡献使开源社区成为一个学习、激励和创造的绝佳场所。你所作的任何贡献都是**非常感谢**的。


1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



### 版本控制

该项目使用Git进行版本管理。您可以在repository参看当前可用版本。

### 作者
zcic@outlook.com


### 版权说明

该项目签署了MIT 授权许可，详情请参阅 [LICENSE.txt](https://github.com/chaospyc/Credit-Card-Risk/master/LICENSE.txt)

### 鸣谢


- [springmvc-mybatis-learning](https://github.com/brianway/springmvc-mybatis-learning)






