package atwom.work.receive_ms_kafka.config.multi_datasource;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", basePackages = {
		"atwom.work.receive_ms_kafka.connect_db.oracle.repository" }, transactionManagerRef = "oracleTransactionManager")
public class OracleDBConfig {

	@Bean(name = "oracleDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("oracleDatasource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		return builder.dataSource(dataSource).packages("atwom.work.receive_ms_kafka.connect_db.oracle.entity")
				.persistenceUnit("Book").build();
	}

	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
