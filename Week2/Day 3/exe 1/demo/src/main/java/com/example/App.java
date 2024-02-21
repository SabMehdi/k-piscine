package com.example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         // Create the application context
         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
         // Get the greeting service bean from the context
         HelloService greetingService = context.getBean(HelloService.class);
         
         // Use the greeting service to say hello
         System.out.println(greetingService.sayHello());
         
         // Close the context to release resources
         context.close();
    }
}
