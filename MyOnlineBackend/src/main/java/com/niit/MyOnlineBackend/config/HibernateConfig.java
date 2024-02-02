package com.niit.MyOnlineBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit.MyOnlineBackend.model")
public class HibernateConfig 
{
	private String Database_Url="jdbc:h2:tcp://localhost/~/test";
	private String Database_Driver="org.h2.Driver";
	private String Database_Dialect="org.hibernate.dialect.H2Dialect";
	private String Database_Username="sa";
	private String Database_Password="12345";
	
	@Bean("datasource")
	public DataSource getDataSource() 
	{
		BasicDataSource dataSource= new BasicDataSource();
		
		//Providing the database connection information
		dataSource.setDriverClassName(Database_Driver);
		dataSource.setUrl(Database_Url);
		dataSource.setUsername(Database_Username);
		dataSource.setPassword(Database_Password);
		return dataSource;
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties= new Properties();
		
		properties.put("hibernate.dialect", Database_Dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.MyOnlineBackend.model");
		return builder.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	}
