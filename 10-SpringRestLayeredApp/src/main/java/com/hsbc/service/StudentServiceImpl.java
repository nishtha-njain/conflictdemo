package com.hsbc.service;

import com.hsbc.dao.StudentDao;
import com.hsbc.exception.DuplicateStudentException;
import com.hsbc.exception.NoSuchStudentException;
import com.hsbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao = null;

    @Override
    public boolean addStudent(Student student)  {
        return dao.createStudent(student);
    }

    @Override
    public Student findStudentById(int studentId){
        return dao.readStudentById(studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        return dao.readAllStudents();
    }

    @Override
    public boolean removeStudentById(int studentId) {
        return dao.deleteStudent(studentId);
    }

    @Override
    public boolean editStudentDetails(Student student) {
        return dao.updateStudent(student);
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }
}
