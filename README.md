# springcloud
自己摸索搭建的springcloud项目
***
[springcloud之Feign、ribbon设置超时时间和重试机制](https://blog.csdn.net/qq_36850813/article/details/102816423)

>我们在微服务调用服务的时候，会使用feign和ribbon，比如有一个实例发生了故障而该情况还没有被服务治理机制及时的发现和摘除，
>这时候客户端访问该节点的时候自然会失败。所以，为了构建更为健壮的应用系统，我们希望当请求失败的时候能够有一定策略的重试机制，而不是直接返回失败。

先看一个配置：
```
#预加载配置,默认为懒加载
ribbon:
  eager-load:
    enabled: true
    clients: zoo-plus-email
 
zoo-plus-email:
  ribbon:
    # 代表Ribbon使用的负载均衡策略
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
    # 每台服务器最多重试次数，但是首次调用不包括在内
    MaxAutoRetries: 1
    # 最多重试多少台服务器
    MaxAutoRetriesNextServer: 1
    # 无论是请求超时或者socket read timeout都进行重试
    OkToRetryOnAllOperations: true
    ReadTimeout: 3000
    ConnectTimeout: 3000
 
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 4000
```
一般情况下 都是 ribbon 的超时时间（<）hystrix的超时时间（因为涉及到ribbon的重试机制） 

Feign重试：
因为ribbon的重试机制和Feign的重试机制有冲突，所以源码中默认关闭Feign的重试机制，具体看一看源码

要开启Feign的重试机制如下：（Feign默认重试五次 源码中有）
```
@Bean
Retryer feignRetryer() {
        return  new Retryer.Default();
}
```

ribbon的重试机制 ：
```
ribbon:
  ReadTimeout: 3000
  ConnectTimeout: 3000
  MaxAutoRetries: 1 #同一台实例最大重试次数,不包括首次调用
  MaxAutoRetriesNextServer: 1 #重试负载均衡其他的实例最大重试次数,不包括首次调用
  OkToRetryOnAllOperations: false  #是否所有操作都重试 
```
计算重试的次数：MaxAutoRetries+MaxAutoRetriesNextServer+(MaxAutoRetries *MaxAutoRetriesNextServer) 

即重试3次 加上第一次调用一共产生4次调用 。

注意：如果在重试期间，时间超过了hystrix的超时时间，便会立即执行熔断，fallback。所以要根据上面配置的参数计算hystrix的超时时间，
使得在重试期间不能达到hystrix的超时时间，不然重试机制就会没有意义 。

hystrix超时时间的计算： (1 + MaxAutoRetries + MaxAutoRetriesNextServer) * ReadTimeout 即按照以上的配置 hystrix的超时时间应该配置为 （1+1+1）*3=9秒

当ribbon超时后且hystrix没有超时，便会采取重试机制。当OkToRetryOnAllOperations设置为false时，只会对get请求进行重试。如果设置为true，
便会对所有的请求进行重试，如果是put或post等写操作，如果服务器接口没做幂等性，会产生不好的结果，所以OkToRetryOnAllOperations慎用。
如果不配置ribbon的重试次数，默认会重试一次 

注意： 默认情况下,GET方式请求无论是连接异常还是读取异常,都会进行重试 ，非GET方式请求,只有连接异常时,才会进行重试 
===========================================================================================================
***
