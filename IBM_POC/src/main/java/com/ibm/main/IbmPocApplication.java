package com.ibm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ibm.config.MyConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@Import({ MyConfig.class})
@SpringBootApplication
@ComponentScan("com.ibm")
@EntityScan(basePackages= {"com.ibm.model"})
@EnableSwagger2
@EnableCaching
public class IbmPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmPocApplication.class, args);
	}
}
