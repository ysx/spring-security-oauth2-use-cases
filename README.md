# spring-security-oauth2-use-cases
spring-security-oauth2 使用案例

## 项目组织

- auth-server （认证&授权中心）
> 使用Spring Boot框架。统一认证中心。
- resource-server （资源中心）
> 使用Spring Boot框架。权限认证都通过认证中心。
- resource-server-ssm （资源中心）
> 使用SSM框架。权限认证都通过认证中心。
- resource-server-ssm-javaconfig （资源中心）
> 使用SSM框架(全注解配置)。权限认证都通过认证中心。

- 客户端：使用Postman充当客户端调用资源中心的接口


## 功能调试
使用Postman调试接口，相关文件为spring-security-oauth2-use-cases.postman_collection.json，导入Postman即可。

