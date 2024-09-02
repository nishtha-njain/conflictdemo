package com.hsbc.service;

import com.hsbc.dao.DeptDao;
import com.hsbc.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DepartmentService{
    @Autowired
    private DeptDao deptDao=null;

    @Override
    public List<Department> findAllDept() {
        return deptDao.readAllDepartments();
    }
}
