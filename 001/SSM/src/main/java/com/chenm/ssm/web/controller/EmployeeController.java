package com.chenm.ssm.web.controller;

import com.chenm.ssm.domain.Employee;
import com.chenm.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName: EmployeeController
 * Function:  TODO  功能说明.
 * <p>
 * date: 2019年12月18日  16:55
 *
 * @author chenm
 * @since JDK 1.8
 * <p>
 * Modified By： <修改人>
 * Modified Date: <修改日期，格式:YYYY-MM-DD>
 * Why & What is modified: <修改描述>
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("index")
    public String index(){
        return "employee/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Employee> list(){
        return employeeService.queryAll();
    }

}