package com.ibm.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ibm.model.Parent;
import com.ibm.model.Student;
import com.ibm.vo.ParentVO;
import com.ibm.vo.StudentVO;

@Configuration
public class MyConfig {

	  @Bean(name = "org.dozer.Mapper")
	  public Mapper configureMapper() {
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    dozerBean.addMapping(beanMappingBuilder());
	    return dozerBean;
	  }

	private BeanMappingBuilder beanMappingBuilder() {
		return new BeanMappingBuilder() {

			@Override
			protected void configure() {
				mapping(StudentVO.class,Student.class,TypeMappingOptions.mapNull(false),
						TypeMappingOptions.mapEmptyString(false));
				mapping(ParentVO.class,Parent.class,TypeMappingOptions.mapNull(false),
					TypeMappingOptions.mapEmptyString(false));
			}
			
		};
	}
	
	@Bean
	RedisTemplate<Object, Object> redisTemplate(){
		
		RedisTemplate<Object, Object> redis = new RedisTemplate<>();
		redis.setConnectionFactory(jedisConnectionFactory());
		return redis;
		
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		  return new JedisConnectionFactory();
	}
	
	
	
}
