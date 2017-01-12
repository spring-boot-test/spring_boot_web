package com.hubert.web.startup;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 加入数据库
 * @author Hubrt
 *
 */
@Configuration    //通过java代码来装配bean
@MapperScan(basePackages = "com.hubert.service.is")
public class DatabaseConfig {
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 将dataSource装配到sessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}
