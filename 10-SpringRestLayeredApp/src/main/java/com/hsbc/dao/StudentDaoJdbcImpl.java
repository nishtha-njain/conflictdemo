package com.hsbc.dao;

import com.hsbc.model.Department;
import com.hsbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class StudentDaoJdbcImpl implements StudentDao {
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private JdbcClient jdbcClient;


    @Override
    public boolean createStudent(Student student) {
        String query = "insert into student values (?,?,?,?)";
        //int result = template.update(query, student.getStudentId(), student.getStudentName(), student.getStudentScore(), student.getDept().getDeptId());
        int result = jdbcClient.sql(query).params(student.getStudentId(), student.getStudentName(), student.getStudentScore(), student.getDept().getDeptId()).update();
        return result == 1;
    }

    @Override
    public Student readStudentById(int studentId) {
        String query = "select * from student where student_id=" + studentId;
        //Student student= (Student) jdbcClient.sql(query).query().singleValue();
        Student student = template.queryForObject(query, new StudentRowMapper());
        return student;
    }

    @Override
    public List<Student> readAllStudents() {
        String query = "select * from student";
        return template.query(query, new StudentRowMapper());
    }

    @Override
    public boolean deleteStudent(int studentId) {
        String query = "delete from student where student_id=?";
        int result = template.update(query, studentId);
        return result == 1;
    }

    @Override
    public boolean updateStudent(Student student) {
        String query = "update student set student_name=?, student_score=?, dept_id=? where student_id=?;";
        int result = template.update(query, student.getStudentName(), student.getStudentScore(), student.getDept().getDeptId(), student.getStudentId());
        return result == 1;
    }
}
