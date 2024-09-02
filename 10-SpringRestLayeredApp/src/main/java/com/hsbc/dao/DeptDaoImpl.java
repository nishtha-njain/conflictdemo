package com.hsbc.dao;

import com.hsbc.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao{
    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<Department> readAllDepartments() {
        String query="select * from department";
        return jdbcClient.sql(query).query(new DeptRowMapper()).list();
    }
}
