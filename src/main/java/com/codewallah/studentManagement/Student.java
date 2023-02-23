//package com.codewallah.studentManagement;
//
//public class Student {
//    public String name; //If not public then it will accessible inside package only and postman won't able to fetch it
//    public int age , admNo , standard;
//
//    public Student(String name, int age, int admNo, int standard) {
//        this.name = name;
//        this.age = age;
//        this.admNo = admNo;
//        this.standard = standard;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getAdmNo() {
//        return admNo;
//    }
//
//    public void setAdmNo(int admNo) {
//        this.admNo = admNo;
//    }
//
//    public int getStandard() {
//        return standard;
//    }
//
//    public void setStandard(int standard) {
//        this.standard = standard;
//    }
//}

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