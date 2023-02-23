package com.codewallah.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //Must annotation --> To tell Springboot in this class API endpoints are written
public class StudentController { //Student Related APIs

    @Autowired //Automatically take care of StudentService object creation
    StudentService studentService; //Object has been created --> so that it can call functions

    @PostMapping("/addStudent") //Add Student
    public ResponseEntity<String> addStudent(@RequestBody() Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/getByAdmNo") //Get Student Object from admNo
    public ResponseEntity<Student> getStudentByAdmNo(@RequestParam("admNo") int admNo){
        //Call service layer
        Student resultStudent = studentService.getStudentByAdmNo(admNo);
        if(resultStudent == null){
            return new ResponseEntity<>(resultStudent , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultStudent , HttpStatus.FOUND);
    }

    @GetMapping("/getAllStudents") //Get list of all Students
    public List<Student> getAllStudents(){
        List<Student> list = studentService.getAllStudents();
        return list;
    }

    @GetMapping("/getByName") //Get Student details by name
    public List<Student> getByName(@RequestParam("requestName") String requestName){
        List<Student> list = studentService.getStudentByName(requestName);
        return list;
    }

    //Path Variable
    @GetMapping("getByPath/{admNo}")
    public Student getByPath(@PathVariable("admNo") Integer admNo){
        Student student = studentService.getStudentByAdmNo(admNo); //Calling Service Layer (We are utilizing functions from service layer)
        return student;
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody() Student student){
        return new ResponseEntity<>(studentService.updateStudent(student) , HttpStatus.ACCEPTED);
    }

    //Return with Status code
    @DeleteMapping("deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam("admNo") int admNo){
        return new ResponseEntity<>(studentService.deleteStudent(admNo) , HttpStatus.OK);
    }
}
