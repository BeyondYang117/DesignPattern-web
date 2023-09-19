# 一个简单的`Java设计模式`项目
    通过模拟简单的业务场景案例，将`Java设计模式`运用到我们的代码当中，让我们更好、更快的理解`Java计模式`，进而灵活运用的我们的实际工作当中。
## 本项目采用的是SSM架构
    SSM是指Spring、SpringMVC和MyBatis三个框架的组合，是一种Java Web开发的常用框架。Spring是一个轻量级的IoC和AOP框架，SpringMVC是基于Spring的MVC框架，MyBatis是一个ORM框架，用于将Java对象映射到数据库中的数据表。SSM框架的组合可以使Java Web开发更加高效、简洁、易于维护。

## 项目结构
一、适配器模式（com.dp.adapterd）
    通过适配器模式实现三方支付，支付宝、微信、银联支付等。

二、责任链模式（com.dp.article）
    通过责任链模式实现文章审核，文章审核需要经过多个人员的审核，每个人员审核通过后，才能进行下一步的审核。

三、组合模式（com.dp.composite）
    通过组合模式实现人员权限管理，人员权限管理需要根据人员的不同级别，进行不同的权限管理。

四、装饰器模式（com.dp.decorator）
    通过装饰器模式来给任何一个service添加相关功能（如日志功能，权限功能等），利用依额注入来动态地选择被装饰的对象。

五、策略模式（com.dp.strategy）
    通过策略模式实现三方支付功能（WECHAT-微信 ALIPAY-支付宝 UNIONPAY-銀联 PAYPAL-PayPal），将它们封装起来，而不影响客户端的使用。
    


