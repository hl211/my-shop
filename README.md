##后台技术:

|* 后台|完成情况|
    *使用`Spring Boot` 构建整个项目去除XML配置 y
	* `Maven`构建项目     y
	* SpringBoot项目在IntelliJ IDEA中实现热部署
	* SpringBoot 自定义Starter 
	* `Jenkins`作为持续集成
	* 采用`Dubbox`作为RPC框架  y
	* `kryo`序列化
	* 使用 `Apollo` 配置中心
	* 使用`Spring`+`Spring MVC`+`MyBatis`SSM框架   y
	* 数据库连接池使用`druid`    y
	* 数据库使用`MySQL`和`Redis`
	* 页面引擎采用 `Beetl`
	* 网页采用`freemarker`生成静态化页面
	* 存储采用`FastDFS`存储图片等文件
	* 采用`Solr`实现搜索服务
	* `Swagger2` 生成 RESTful Apis文档
	* 负载均衡使用`Nginx`、`keepalived`实现高可用  y
	* 采用`Spring Scheduled`做任务调度
	* 消息中间件采用`RabbitMQ`
	* 在分布式事务上则采用了[TCC](https://github.com/changmingxie/tcc-transaction)解决订单支付方面时效性要求性高的分布式事务,可靠的消息服务则来解决如会计记录等时效性要求低的分布式事务.
* 前台
	* 采用基于[AdminLTE](https://github.com/almasaeed2010/AdminLTE)的[roncoo-adminLTE](https://github.com/roncoo/roncoo-adminLTE)(主要增加了Ajax的布局模式)
	* AdminLTE集成太多Js这里就不一一列举了

##注意事项
*lombok---用于pojo注解get与set的包，除了maven加依赖后，
          还需要在idea安装插件
*springboot dubbo 测试只需要在测试类上
	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = XbinStoreServiceAdminApplication.class)
	类不是新建，而是注入的方式
*mybatis 生成代码
*druid数据库连接池
   密码没有加密，设置config.decrypt=false

	
## 需求分析列表(完成是y)
	*1、日志过滤器
	*2、数据库异常处理----有run捕获
	*3、完成添加、修改表单
	*4、完成查询功能，查询条件为账号
	*5、完成角色模块
	*6、完成权限模块
	*7、完成shiro权限控制
	
#访问的页面地址
http://localhost:8100/swagger-ui.html