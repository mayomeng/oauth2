package sinosoftsh.security.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

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
