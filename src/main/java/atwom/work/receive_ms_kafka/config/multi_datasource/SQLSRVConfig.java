//package atwom.work.receive_ms_kafka.config.multi_datasource;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "sqlsrvEntityManagerFactory", basePackages = {
//        "atwom.work.receive_ms_kafka.connect_db.sqlsrv.repository"}, transactionManagerRef = "sqlsrvTransactionManager")
//public class SQLSRVConfig {
//
//    @Bean(name = "sqlsrvDatasource")
//    @ConfigurationProperties(prefix = "spring.datasource.sqlsrv")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "sqlsrvEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
//                                                                           @Qualifier("sqlsrvDatasource") DataSource dataSource) {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
//        return builder.dataSource(dataSource).packages("atwom.work.receive_ms_kafka.connect_db.sqlsrv.entity")
//                .build();
//    }
//
//    @Bean(name = "sqlsrvTransactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("sqlsrvEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
