package com.guru.springframework;

import com.guru.springframework.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml") //will look for the xml configuration and bring it
public class DependencyInjectionApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		GreetingController controller = (GreetingController) ctx.getBean("greetingController");
		controller.sayHello();
	}
}
