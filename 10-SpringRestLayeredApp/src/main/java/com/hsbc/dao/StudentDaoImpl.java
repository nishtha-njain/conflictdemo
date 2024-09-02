package com.hsbc.dao;

import com.hsbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    //@Qualifier("studentDB")
    private List<Student> studentDB = null;

    @Override
    public boolean createStudent(Student student) {
        return studentDB.add(student);
    }

    @Override
    public Student readStudentById(int studentId) {
        Student student = null;
        Optional<Student> optional = studentDB.stream().filter(s -> s.getStudentId() == studentId).findFirst();
        if (optional.isPresent())
            student = optional.get();
        return student;
    }

    @Override
    public List<Student> readAllStudents() {
        return studentDB;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }


    public void setStudentDB(List<Student> studentDB) {
        this.studentDB = studentDB;
    }
}
