package com.yuraloga.ecarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 Run with properties:
    -Dspring.profiles.active=local
    -Dserver.port=10000
    -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/test
    -Dspring.datasource.username=root
    -Dspring.datasource.password=root
    -Dspring.datasource.driver-class-name=org.postgresql.Driver
    -Dspring.jackson.serialization.fail-on-empty-beans=false
    -Dspring.jpa.hibernate.ddl-auto=validate
    -Dspring.jpa.hibernate.dialect=com.yuraloga.ecarservice.configuration.CustomPostgreSQLDialect
    -Dspring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
 */
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcarServiceLocal {

    public static void main(String[] args) {
        SpringApplication.run(EcarServiceLocal.class, args);
    }
}
