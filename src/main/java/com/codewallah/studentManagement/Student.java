package com.codewallah.studentManagement;

public class Student {
    public String name; //If not public then it will accessible inside package only and postman won't able to fetch it
    public int age , admNo , standard;

    public Student(String name, int age, int admNo, int standard) {
        this.name = name;
        this.age = age;
        this.admNo = admNo;
        this.standard = standard;
    }
}
