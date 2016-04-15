package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

    @Configuration
    @ComponentScan(basePackages = {"project.dao", "project.model"})
    @PropertySource("classpath:/app.properties")
    public class RootConfig extends WebMvcConfigurerAdapter {

        @Autowired
        private Environment env;

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
            dataSource.setUrl(env.getProperty("jdbc.uri"));
            dataSource.setUsername(env.getProperty("db.user"));
            dataSource.setPassword(env.getProperty("db.password"));;
            return dataSource;
        }


}