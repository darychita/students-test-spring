package com.company;

import com.company.application.presentation.TestRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@ComponentScan
@Configuration
public class MainConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MainConfig.class);

        context.getBean(TestRunner.class).runTest();
    }
}
