package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            
            // Get the greeting service bean from the context
            HelloService greetingService = context.getBean("greetingService", HelloService.class);
            
            // Use the greeting service to say hello
            System.out.println(greetingService.Hello());
        }
        // The context is automatically closed due to the try-with-resources statement
    }
}
