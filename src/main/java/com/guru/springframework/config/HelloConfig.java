package com.guru.springframework.config;

import com.guru.springframework.services.HelloWorldFactory;
import com.guru.springframework.services.HelloWorldService;
import com.guru.springframework.services.HelloWorldServiceEnglishImpl;
import com.guru.springframework.services.HelloWorldServiceSpanishImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Remove Annotation to use Java Sprint configuration classes
 *
 * NOTE: This is better more commonly used when dealing with 3rd party libraries, this could be mix with normal annotation
 */
@Configuration
public class HelloConfig {

    @Bean
    public HelloWorldFactory helloWorldFactory() {
        return new HelloWorldFactory();
    }

    @Bean
    @Profile("english")
    @Primary //Primary attribute, will avoid errors when beans have the same type. "Default bean"
    public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory) {
        return factory.createHelloWorldService("en");
    }

    @Bean
    @Profile("spanish")
    @Primary
    public HelloWorldService helloWorldServiceSpanish(HelloWorldFactory factory) {
        return factory.createHelloWorldService("es");
    }

    //Autowired example
    @Bean(name = "french") //adding a name to the bean will avoid errors when autowiring by type
    // Note: add @Qualifier and name of the bean on impl class, plus bean object
    public HelloWorldService helloWorldServiceFrench(HelloWorldFactory factory) {
        return factory.createHelloWorldService("fr");
    }

    @Bean
    public HelloWorldService helloWorldServiceGerman(HelloWorldFactory factory) {
        return factory.createHelloWorldService("de");
    }

    @Bean
    public HelloWorldService helloWorldServicePolish(HelloWorldFactory factory) {
        return factory.createHelloWorldService("pl");
    }

    @Bean
    public HelloWorldService helloWorldServiceRussian(HelloWorldFactory factory) {
        return factory.createHelloWorldService("ru");
    }

}
