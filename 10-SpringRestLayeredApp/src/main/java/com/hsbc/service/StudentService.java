package com.hsbc.service;

import com.hsbc.model.Student;

import java.util.List;


public interface StudentService {
    boolean addStudent(Student student) ;
    Student findStudentById(int studentId) ;
    List<Student> findAllStudents();
    boolean removeStudentById(int studentId);
    boolean editStudentDetails(Student student);
}
