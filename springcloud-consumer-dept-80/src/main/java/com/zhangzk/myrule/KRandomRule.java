
package com.zhangzk.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//这玩意是我粘 new KRandomRule();中的，直接全部粘过来的
public class KRandomRule extends AbstractLoadBalancerRule {

    //每个服务,访问5次~，换下一个服务（3个）

    //total=0，默认=0，如果=5，我们指向下一个服务节点
    //index=0,默认0，如果total=5，index+1

    private int total = 0; //被调用的次数
    private int currentIndex = 0; //当前是谁在提供服务

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获得活着的服务
                List<Server> allList = lb.getAllServers();//获得全部的服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);//生成区间随机数
//                server = (Server)upList.get(index);//从或者的服务中，随机获取一个
                //============================================================

                if(total<5){
                    //在活着的服务中获取当前的提供服务的人
                    server = upList.get(currentIndex);
                    //计数++
                    total++;
                }else {
                    //不满足条件 计数变成0
                    total = 0;
                    // 节点数加1（指向下一个节点）
                    currentIndex++;
                    //如果当前节点大于活着的数量，归零重新再来
                    if(currentIndex>upList.size()){
                        currentIndex = 0;
                    }
                    //从活着的服务中,获取指定的服务来进行操作
                    upList.get(currentIndex);

                }

                //============================================================
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
