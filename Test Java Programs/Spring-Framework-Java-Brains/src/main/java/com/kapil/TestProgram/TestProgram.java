package com.kapil.TestProgram;

import com.google.gson.Gson;

public class TestProgram {
    public static void main(String args[]){
        System.out.println("Hello World");
        Employee emp = new Employee(29,"kapil");
        Gson gson = new Gson();
        String empJson = gson.toJson(emp);
        System.out.println("Emp json is " + empJson);
    }
}
class Employee{
    private int age;
    private String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }
}