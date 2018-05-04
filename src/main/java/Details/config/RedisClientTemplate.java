package Details.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:23
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Component
public class RedisClientTemplate {

    @Autowired
    private JedisCluster jedisCluster;

    public String setToRedis(String key , String value){
        return jedisCluster.set(key, value);
    }
}
