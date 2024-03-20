package com.sona.controller;

import com.sona.model.Employee;
import com.sona.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


 private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
      return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity<List<Employee>>getAllEmployee()
    {
        return  new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id)
    {
        Employee employeeById = employeeService.getEmployeeById(id);
   return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);

    }
    @PostMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee,@PathVariable long id)
    {
        Employee employee1 = employeeService.updateEmployee(employee, id);
    return  new ResponseEntity<Employee>(employee1,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable long id)
    {
        employeeService.DeleteEmp(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }

}
