package com.chenm.ssm.service;

import com.chenm.ssm.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    void add(Employee employee);
    List<Employee> queryAll();


}
