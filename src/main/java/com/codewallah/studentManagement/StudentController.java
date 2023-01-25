package com.codewallah.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //Must annotation --> To tell Springboot in this class API endpoints are written
public class StudentController { //Student Related APIs
    //Make database
    HashMap<Integer, Student> studentDB = new HashMap<>(); //Define a database

    @PostMapping("/addStudent") //Add Student
    public String addStudent(@RequestBody() Student student){
        int admNo = student.admNo;
        studentDB.put(admNo , student); //Add to database
        return("Student has been created successfully");
    }
    @GetMapping("/getByAdmNo") //Get Student Object from admNo
    public Student getStudentByAdmNo(@RequestParam("admNo") int admNo){
        Student student = studentDB.get(admNo);
        return student;
    }

    @GetMapping("/getAllStudents") //Get list of all Students
    public List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        for(Map.Entry<Integer,Student> mapElement : studentDB.entrySet()){
            int admNo = mapElement.getKey();
            Student s = mapElement.getValue();
            list.add(s);
        }
        return list;
    }

    @GetMapping("/getByName") //Get Student details by name
    public List<Student> getByName(@RequestParam("requestName") String requestName){
        List<Student> list = new ArrayList<>();
        for(Map.Entry<Integer,Student> mapElement : studentDB.entrySet()){
            String studentName = mapElement.getValue().name;
//            System.out.println(studentName);
            if(studentName.equals(requestName)){
                list.add(mapElement.getValue());
                System.out.println(list);
            }
        }
        return list;
    }

}
