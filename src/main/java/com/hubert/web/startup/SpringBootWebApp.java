package com.hubert.web.startup;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.hubert.core.boot.BaseWebApplication;

@SpringBootApplication
@EnableConfigurationProperties     //这个注解告诉Spring Boot 使能支持@ConfigurationProperties。如果不指定会看到如下异常:org.springframework.beans.factory.NoSuchBeanDefinitionException
@ComponentScan(basePackages = {"com.hubert.core","com.hubert.service","com.hubert.web","com.hubert.common"})    //自动扫描  base-pack下面或者子包下面的Java文件，如果扫描到有@Component @Controller@Service等这些注解的类，则把这些类注册为bean
public class SpringBootWebApp extends BaseWebApplication{

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootWebApp.class, args);
		new SpringBootWebApp().run(args);
	}
}
