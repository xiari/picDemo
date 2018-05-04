package Details.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:23
 * Desc:
 * redis 的集成涉及到如下：
 * 1， 基本配置属性，如host, 超时时间
 * 2， 集群配置、连接池、连接工厂。
 * 3， 客户端
 */

@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        for (String hostAndPortStr :  redisProperties.getNodes()
             ) {
            HostAndPort hostAndPort = new HostAndPort(hostAndPortStr.split(":")[0]
                    ,Integer.valueOf(hostAndPortStr.split(":")[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet);
    }

    /**
     * 集群配置自定义
     * @return
     */
//    @Bean
//    public RedisClusterConfiguration redisClusterConfiguration(){
//        Map<String, Object> source = new HashMap<>();
//        source.put("spring.redis.cluster.nodes", redisProperties.getClusterNodes());
////        source.put("spring.redis.cluster.timeout", redisProperties.getConnectionTimeOut());
//        return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
//    }

    /**
     * 连接池工厂
     * @return
     */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        return new JedisConnectionFactory(redisClusterConfiguration(),jedisPoolConfig());
//    }
//    @Bean
//    public RedisTemplate redisTemplateFactory(){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }

    /**
     * jedis 连接池
     * @return
     */
//    private JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////        jedisPoolConfig.setMaxIdle(jedisConfigProperties.getMaxIdle());
////        jedisPoolConfig.setMaxWaitMillis(jedisConfigProperties.getMaxWaitMills());
////        jedisPoolConfig.setMinIdle(jedisConfigProperties.getMinIdle());
////        jedisPoolConfig.setTestOnBorrow(jedisConfigProperties.isTestOnBorrow());
////        jedisPoolConfig.setTestOnReturn(jedisConfigProperties.isTestOnReturn());
//        return jedisPoolConfig;
//    }
}
