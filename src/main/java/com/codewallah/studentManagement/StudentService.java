package com.codewallah.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //Must annotation --> To tell Springboot this class is of Service Layer (Business Logic/Processing happens)
public class StudentService {

    //Option 1 is to create an object by myself , Don't need to do it because of Autowired
    // StudentRepository obj = new StudentRepository();

    @Autowired //Used to connect different Classes via object , Option 2 - Autowired create object automatically
    StudentRepository studentRepository; //The Bean(object created by spring) was created and put in IOC [Inversion of Control] container

    String addStudent(Student student){
        String result = studentRepository.addStudentToDB(student);
        return result;
    }

    Student getStudentByAdmNo(Integer admNo){
        //Call repository layer
        Student student = studentRepository.getStudentByAdmNoFromDB(admNo);
        return student;
    }

    List<Student> getStudentByName(String name){
        List<Student> list = studentRepository.getStudentByNameFromDB(name);
        return list;
    }

    List<Student> getAllStudents(){
        List<Student> list = studentRepository.getAllStudentsFromDB();
        return list;
    }

    Student updateStudent(Student student){
        Student update = studentRepository.updateStudentFromDB(student);
        return update;
    }

    String deleteStudent(int admNo){
        String result = studentRepository.deleteStudentFromDB(admNo);
        return result;
    }
}
