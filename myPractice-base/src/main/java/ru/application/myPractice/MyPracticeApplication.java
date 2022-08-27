package ru.application.myPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
