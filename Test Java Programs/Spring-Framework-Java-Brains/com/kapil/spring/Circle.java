package com.kapil.spring;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class Circle implements Shape{

    @Resource(name = "pointC")
    private Point center;

//    public Point getCenter() {
//        return center;
//    }
//
//    public void setCenter(Point center) {
//        this.center = center;
//    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with center: " + this.center);
    }
}
