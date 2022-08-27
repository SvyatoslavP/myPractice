package ru.application.myPractice;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPracticeApplication.class, args);
    }

    /**
     * чистит логи liquibase
     */
//    @Bean
//    public SpringLiquibase liquibase() {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setShouldRun(false);
//        return liquibase;
//    }
}
