package br.com.bluebank.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL)
			.addScript("db/create-db.sql")
			.addScript("db/populate-db.sql")
			.build();
		return db;
	}
	
//	https://www.mkyong.com/spring/spring-embedded-database-examples/
//	@PostConstruct
//	public void startDBManager() {
//
//		//hsqldb
//		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
//
//	}
	
}
