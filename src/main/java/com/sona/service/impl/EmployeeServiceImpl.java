package com.sona.service.impl;

import com.sona.exception.ResourceNotFoundException;
import com.sona.model.Employee;
import com.sona.repository.EmployeeRepository;
import com.sona.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
    return  all;
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employeeById = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
   return employeeById;
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        Employee save = employeeRepository.save(employee1);
    return save;
    }

    @Override
    public void DeleteEmp(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
   employeeRepository.deleteById(id);
    }

}
