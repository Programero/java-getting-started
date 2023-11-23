package com.kapil.spring;

public class Triangle{
//    private String type;
//
//    public Triangle(String type){
//        this.type=type;
//    }
//    public void setType(String type) {
//        this.type = type;
//    }
     private Point point1;
     private Point point2;
     private Point point3;

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public void draw(){
//        System.out.println("Drawing a Triangle of type: " + type);
        System.out.println("Drawing a triangle from " + this.point1 + " to " + this.point2 + " to " + this.point3);
    }
}
