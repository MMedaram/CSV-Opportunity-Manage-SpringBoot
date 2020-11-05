package com.dbadapters.core.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.configexample.util.DefinedProperties;
import com.configexample.util.PropNameConstant;
import com.configexample.util.PropertyConstant;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",basePackages = {"com.example.core.repository"})
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {

		DefinedProperties dp = new DefinedProperties();
		dp.initiate(PropNameConstant.DB_DETAILS);
		boolean isMYSQLDB = true;
		String driverClass = "";
		String url = "";
		String userName = "";
		String password = "";

		if (isMYSQLDB) {
			driverClass = dp.getProperty(PropertyConstant.MYSQLDRIVERCLASS);
			url = dp.getProperty(PropertyConstant.MYSQLURL);
			userName = dp.getProperty(PropertyConstant.MYSQLUSERNAME);
			password = dp.getProperty(PropertyConstant.MYSQLPASSWORD);
		} else {

			driverClass = dp.getProperty(PropertyConstant.POSTGRESDRIVERCLASS);
			url = dp.getProperty(PropertyConstant.POSTGRESURL);
			userName = dp.getProperty(PropertyConstant.POSTGRESUSERNAME);
			password = dp.getProperty(PropertyConstant.POSTGRESPASSWORD);
		}
		System.out.println("DB CONNECTION DETAILS:::"+driverClass + " " +url + " " +userName + " "+password);
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClass);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);

		return dataSourceBuilder.build();
	}
	
}
