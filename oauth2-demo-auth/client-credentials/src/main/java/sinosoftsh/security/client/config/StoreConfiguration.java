package sinosoftsh.security.client.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/17.
 */
@Configuration
public class StoreConfiguration {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() throws IOException {

       JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(3);
        jedisPoolConfig.setMaxTotal(3);

        jedisPoolConfig.setMaxWaitMillis(2000);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        jedisConnectionFactory.setHostName("10.2.36.40");
        jedisConnectionFactory.setPort(6379);

        return jedisConnectionFactory;

/*        Set<RedisNode> redisNodes = new HashSet<RedisNode>();
        redisNodes.add(new RedisNode("10.2.36.106", 7000));
        redisNodes.add(new RedisNode("10.2.36.106", 7001));
        redisNodes.add(new RedisNode("10.2.36.106", 7002));

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.setClusterNodes(redisNodes);

        return new JedisConnectionFactory(redisClusterConfiguration);*/

    }
}
