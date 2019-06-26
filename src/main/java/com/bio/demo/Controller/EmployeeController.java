package com.bio.demo.Controller;

import com.bio.demo.DataClass.ResponseObject;
import com.bio.demo.Service.EmployeeService;
import com.bio.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseObject getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @PostMapping
    public ResponseObject addEmployee(@RequestBody @Valid Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("{id}")
    public ResponseObject updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("{id}")
    public ResponseObject deleteEmployee(@PathVariable UUID id){
        return employeeService.deleteEmployee(id);
    }
}
