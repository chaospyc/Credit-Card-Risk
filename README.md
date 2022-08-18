

# 商业银行信用卡风险管理系统
这是一个商业银行信用卡风险管理系统
主要包括：登录管理，权限管理，客户管理和信用卡管理




###### 开发前的配置要求


1. Windows 10环境
2. IDEA / Shell 开发工具
1. Java JDK 1.8 

###### **安装步骤**

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo

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




### 部署

暂无

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






