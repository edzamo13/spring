package com.spring.jdbc.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.TransactionManager;

@Configuration
@EnableJdbcRepositories
public class ApplicationConfig extends AbstractJdbcConfiguration {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builDatabase = new EmbeddedDatabaseBuilder();
		return builDatabase.setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean
	NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
		return namedParameterJdbcOperations(dataSource);
	}

	@Bean
	TransactionManager manager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
