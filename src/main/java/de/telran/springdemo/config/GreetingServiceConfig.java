package de.telran.springdemo.config;

import de.telran.springdemo.service.GreetingService;
import de.telran.springdemo.service.GreetingServiceImpl;
import de.telran.springdemo.service.GreetingServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GreetingServiceConfig {
    @Bean
    @Primary
    public GreetingService getProd(){
        return new GreetingServiceImpl();
    }

    @Bean
    public GreetingService getTest(){
        return new GreetingServiceImpl2();
    }
}
