package com.senla.internship.starter;

import com.senla.internship.starter.aspect.LoggingAspect;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoggerConf {

    @Bean
    @ConditionalOnMissingBean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
