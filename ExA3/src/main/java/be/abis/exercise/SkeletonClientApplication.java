package be.abis.exercise;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class SkeletonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkeletonClientApplication.class, args);
	}
	
	@Bean
	@Profile("production")
	public DataSource testDataSource(){
		return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.DERBY)
					.addScript("classpath:create_course_table_derby.sql")
					.build();
	}
	
	@Bean
	@Profile("production")
	public JdbcTemplate jdbcTemplateDerby(){
		return new JdbcTemplate(testDataSource());
	}

}
