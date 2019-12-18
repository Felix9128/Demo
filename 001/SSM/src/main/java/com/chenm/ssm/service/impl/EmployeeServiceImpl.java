package com.chenm.ssm.service.impl;


import com.chenm.ssm.domain.Employee;
import com.chenm.ssm.mapper.EmployeeMapper;
import com.chenm.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional
    @Override
    public void add(Employee employee) {

    }

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.selectAll();
    }
}
