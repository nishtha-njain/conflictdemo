package com.hsbc.dao;

import com.hsbc.model.Department;

import java.util.List;

public interface DeptDao {
    List<Department> readAllDepartments();
}
