package com.kapil.spring;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
        //We would now don't initialize the Triangle directly, rather depend upon BeanFactory to create initialize and manage the Triangle class objects
        //Triangle triangle = new Triangle();
        //BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();
    }
}