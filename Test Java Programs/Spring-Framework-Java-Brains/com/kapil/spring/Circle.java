package com.kapil.spring;

import com.kapil.spring.annotations.Retry;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class Circle implements Shape{

    @Resource(name = "pointC")
    private Point center;

    public Circle(){}
    public Circle(Point center){
        this.center = center;
    }

//    public Point getCenter() {
//        return center;
//    }
//
//    public void setCenter(Point center) {
//        this.center = center;
//    }

    @Override
    @Retry(max_retries = 4)
    public void draw() throws Exception{
        throw new Exception("Throwing exception");
//        System.out.println("Drawing a circle with center: " + this.center);
    }
}
