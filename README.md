
#测试-启动参考(端口自查yml)
##测试,轮询,随询
启动springcloud-eureka-7000系列,启动springcloud-provider-dept-8000系列,最后启动80
###测试feign
启动springcloud-eureka-7000系列,启动springcloud-provider-dept-8000系列,最后启动feign
##测试熔断
启动springcloud-eureka-7000系列,启动springcloud-provider-dept-hystrix-8001,最后启动80
##测试熔断_降级
启动springcloud-eureka-7000系列,启动springcloud-provider-dept-8000系列,最后启动80,然后关闭8000一个或多个,进行测试
##测试监控
(先检查每个springcloud-provider-dept-8000系列actuator完善监控信息,以及检查启动类有没有添加被监控信息)

启动springcloud-eureka-7000系列,启动springcloud-consumer-dept-dashboard,启动8001系列

(先访问springcloud-eureka-7,在访问springcloud-provider-dept-8,然后springcloud-consumer-dept-dashboard,将8访问的端口后加上/actuator/hystrix.stream填入9监控页面中的表单中,然后填写信息完毕之后启动监控流,之后访问各种8的服务对比着监控进行配合测试)
##测试路由网关
启动springcloud-config-eureka-7001系列,启动springcloud-provider-dept-hystrix-8001,启动9527

(测试7,测试8,测试9在hosts文件中起的名字,加上微服务的名字,加上请求路径,例如下方对比)
####普通访问 http://localhost:8001/dept/get/1
####网关路由 http://zuul9527.com:9527/springcloud-provider-dept/dept/get/1
####      起了别名之后 http://zuul9527.com:9527/mydept/dept/get/1
####      加了公共前缀之后 http://zuul9527.com:9527/zhangzk/mydept/dept/get/1

##访问git
启动3344,访问例下：

http://localhost:3344/application-dev.yml

http://localhost:3344/application/dev/master

http://localhost:3344/master/application-dev.yml

##测试远程访问配置文件
启动springcloud-config-server-3344(config服务),

启动springcloud-config-eureka-7001(config客户),

启动springcloud-config-dept-8001(config客户)
(然后正常访问就是了)





#打开访问
####http://eureka7001.com:7001/
####http://eureka7002.com:7002/
####http://eureka7003.com:7003/
####http://localhost/consumer/dept/get/1

####http://localhost:9001/hystrix

