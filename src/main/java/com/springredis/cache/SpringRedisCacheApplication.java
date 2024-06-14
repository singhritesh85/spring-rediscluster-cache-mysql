package com.springredis.cache;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@Configuration
@EnableCaching
public class SpringRedisCacheApplication {
	
	@Value("${redis.config.isClustered: false}")
	private Boolean isClustered;
	
	@Value("${redis.config.cluster.nodes: null}")
	private List<String> nodes;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCacheApplication.class, args);
	}
	
	@Bean
	  JedisConnectionFactory redisConnectionFactory() {
		
//		if (isClustered) {
			
			List<String> nodes = Collections.singletonList("springboot-redis-cluster.xd2vr8.clustercfg.use2.cache.amazonaws.com:6379");
			RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration( nodes );
		    return new JedisConnectionFactory(clusterConfiguration);
			
//		}
		
		// does not make sense to inject localhost host or loopback ip
//		return new JedisConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
	  }


	  @Bean
	  RedisTemplate<String, String> redisTemplate() {

	    RedisTemplate<String, String> template = new RedisTemplate<>();
	    template.setConnectionFactory(redisConnectionFactory());
	    return template;
	  }

}

