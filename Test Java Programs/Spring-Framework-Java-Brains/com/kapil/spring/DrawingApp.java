package com.kapil.spring;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class DrawingApp {
    public static void main(String[] args) {
        //We would now don't initialize the Triangle directly, rather depend upon BeanFactory to create initialize and manage the Triangle class objects
        //Triangle triangle = new Triangle();
        //BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(DrawingApp.class);
        Shape shape = (Shape) context.getBean("circle");
        try {
            shape.draw();
        } catch(Exception ex){
            System.out.println(ex);
        }
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

    @Bean("pointA")
    public Point pointA(){
        return new Point((float)0.0,(float)20.0);
    }

    @Bean("pointB")
    public Point pointB(){
        return new Point((float)20.0,(float)20.0);
    }

    @Bean("pointC")
    public Point pointC(){
        return new Point((float)20.0,(float)0.0);
    }


}