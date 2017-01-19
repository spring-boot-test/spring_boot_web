package com.hubert.web.startup;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageHelper;

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
		
		//分页插件  
        PageHelper pageHelper = new PageHelper();  
        Properties props = new Properties();  
        props.setProperty("reasonable", "true");  
        props.setProperty("supportMethodsArguments", "true");  
        props.setProperty("returnPageInfo", "check");  
        props.setProperty("params", "count=countSql");  
        pageHelper.setProperties(props);  
        //添加插件  
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});  
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        // 指定mybatisxml文件路径
//        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mybatis-config.xml"));
        
		return sessionFactory.getObject();
	}
}
