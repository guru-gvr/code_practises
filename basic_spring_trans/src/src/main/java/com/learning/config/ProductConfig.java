package src.main.java.com.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ProductConfig {

    @Bean
    public DataSource dataSource() {
     return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/ecommerce","postgres","postgres");
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return  new JdbcTemplate(dataSource());
    }

    @Bean public TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
