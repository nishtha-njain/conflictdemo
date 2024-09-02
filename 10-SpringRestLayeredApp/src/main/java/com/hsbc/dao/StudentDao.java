package com.hsbc.dao;

import com.hsbc.exception.DuplicateStudentException;
import com.hsbc.exception.NoSuchStudentException;
import com.hsbc.model.Student;

import java.util.List;


public interface StudentDao {
    boolean createStudent(Student student);
    Student readStudentById(int studentId) ;
    List<Student> readAllStudents();
    boolean deleteStudent(int studentId);
    boolean updateStudent(Student student);
}
