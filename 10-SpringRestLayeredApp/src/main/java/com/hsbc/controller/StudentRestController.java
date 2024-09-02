package com.hsbc.controller;

import com.hsbc.exception.NoSuchStudentException;
import com.hsbc.model.Department;
import com.hsbc.model.Student;
import com.hsbc.service.DepartmentService;
import com.hsbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "students")
@CrossOrigin
public class StudentRestController {
    @Autowired
    private StudentService service;

    @Autowired
    private DepartmentService deptService;

    //http://localhost:9091/students --get
    @GetMapping(path = "")
    public List<Student> getAllStudents() {
        return service.findAllStudents();
    }

    //http://localhost:9091/students --post
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        ResponseEntity<String> response = null;
        boolean result = service.addStudent(student);
        if (result)
            response = new ResponseEntity<>("Student is added", HttpStatus.CREATED);
        else
            response=new ResponseEntity<>("Student is not added",HttpStatus.BAD_REQUEST);
        return response;
    }

    //http://localhost:9091/students/{studentId}
    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return service.findStudentById(studentId);
    }

    //http://localhost:9091/students/{studentId}
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId){
        ResponseEntity<String> response=null;
        boolean result=service.removeStudentById(studentId);
        if(result){
            response=new ResponseEntity<>("Student "+studentId+" is deleted",HttpStatus.OK);
        } else {
            response=new ResponseEntity<>("Could not delete the student",HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    //http:localhost:9091/students/departments
    @GetMapping(path = "/departments")
    public List<Department> getDepartments(){
        return deptService.findAllDept();
    }

    @ExceptionHandler(NoSuchStudentException.class)
    @ResponseStatus(reason = "Student Not Found",code = HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(){
        //log the exception
    }

}
