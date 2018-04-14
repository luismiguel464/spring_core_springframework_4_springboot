package com.guru.springframework.controllers;

import com.guru.springframework.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by donaldsmallidge on 8/31/16.
 */
@Controller
public class GreetingController {

    private HelloWorldService helloWorldService;

    //bean for french
    private HelloWorldService helloWorldServiceFrench;

    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Autowired
    @Qualifier("french") //by name
    public void setHelloWorldServiceFrench(HelloWorldService helloWorldServiceFrench) {
        this.helloWorldServiceFrench = helloWorldServiceFrench;
    }

    public String sayHello() {
        String greeting = helloWorldService.getGreeting();

        System.out.println(greeting);

        //print out french
        System.out.println(helloWorldServiceFrench.getGreeting());

        return greeting;
    }
}
