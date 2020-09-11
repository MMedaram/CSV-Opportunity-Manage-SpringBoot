package com.example.core.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",basePackages = {"com.example.core.repository"})
@EnableTransactionManagement
public class DataSourceConfig {

//	@Value("${server.port}")
//	private String defaultName;
//	
   /* @Bean
    public DataSource getDataSource() {
    	String driverClass="org.postgresql.Driver";
    	String url="jdbc:postgresql://localhost:5432/emp";
    	String userName="postgres";
    	String password="postgres";
    	
    	DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClass);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
*/
      @Bean
       public DataSource getDataSource() {
    	DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    	dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/emp?createDatabaseIfNotExist=true");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

}
