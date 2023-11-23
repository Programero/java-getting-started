package com.kapil.spring;

public class Triangle{
    private String type;

    public Triangle(String type){
        this.type=type;
    }
//    public void setType(String type) {
//        this.type = type;
//    }

    public void draw(){
        System.out.println("Drawing a Triangle of type: " + type);
    }
}
