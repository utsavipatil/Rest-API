package com.codewallah.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //Must annotation --> To tell Springboot this class is of Repository Layer (Database Related Code - DB connections)
public class StudentRepository {
    HashMap<Integer, Student> studentDB = new HashMap<>(); //Define a database

    String addStudentToDB (Student student){
        int admNo = student.admNo;
        studentDB.put(admNo , student); //Add to database
        return "Successfully Added";
    }

    Student getStudentByAdmNoFromDB (int admNo){
        if(studentDB.containsKey(admNo)){
            return studentDB.get(admNo);
        }else{
            return null;
        }
    }

    List<Student> getStudentByNameFromDB (String name){
        List<Student> list = new ArrayList<>();
        for(int key : studentDB.keySet()){
            Student studentName = studentDB.get(key);
            if(studentName.name.equals(name)){
                list.add(studentDB.get(key));
            }
        }
        return list;
    }

    List<Student> getAllStudentsFromDB(){
        List<Student> list = new ArrayList<>();
        for(Map.Entry<Integer,Student> mapElement : studentDB.entrySet()){
            int admNo = mapElement.getKey();
            Student s = mapElement.getValue();
            list.add(s);
        }
        return list;
    }

    Student updateStudentFromDB(Student student){
        int key = student.admNo;
        studentDB.put(key , student);
        return student;
    }

    String deleteStudentFromDB(int admNo){
        studentDB.remove(admNo);
        return "Delete Successfully";
    }
}
