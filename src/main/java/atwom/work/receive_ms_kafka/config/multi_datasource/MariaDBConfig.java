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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mariaDBEntityManagerFactory", basePackages = {
        "atwom.work.receive_ms_kafka.connect_db.mariadb.repository"}, transactionManagerRef = "mariaDBTransactionManager")
public class MariaDBConfig {
    @Primary
    @Bean(name = "mariaDBDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.mariadb")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mariaDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("mariaDBDatasource") DataSource dataSource) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        return builder.dataSource(dataSource).packages("atwom.work.receive_ms_kafka.connect_db.mariadb.entity")
                .build();
    }

    @Primary
    @Bean(name = "mariaDBTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mariaDBEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
