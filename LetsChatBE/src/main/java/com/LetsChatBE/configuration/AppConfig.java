package com.LetsChatBE.configuration;


import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.LetsChatBE")
public class AppConfig
{
@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    dataSource.setUsername("ANISH");
	    dataSource.setPassword("anish");
	    return dataSource;
	}	
	
	
	 /*
	   @Bean(name = "dataSource")
	   public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/mydb");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
     }*/
	
	
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.LetsChatBE.model");
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);	 
	return transactionManager;
	}
	
	
	public void ResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/WEB-INF/resources/image");
	}
	
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver(){
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);//20 MB
		multipartResolver.setMaxInMemorySize(1048576);//1 MB
		return multipartResolver;
	}
	}
