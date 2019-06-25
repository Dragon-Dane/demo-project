package com.bio.demo.Service;

import com.bio.demo.DataClass.ResponseObject;
import com.bio.demo.Execptions.ServiceExceptionHolder;
import com.bio.demo.Repository.EmployeeRepository;
import com.bio.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApiResponseService apiResponseService;

    public ResponseObject getAllEmployee() {
        return apiResponseService.sendListResponse("Employee", employeeRepository.findAll());
    }

    public ResponseObject addEmployee(@Valid Employee employee) {
        return apiResponseService.sendCreateResponse("Employee", employeeRepository.save(employee));
    }

    public ResponseObject updateEmployee(@Valid Employee employee, UUID id) {
        employee.setId(id);
        return apiResponseService.sendUpdateResponse("Employee", employeeRepository.save(employee));
    }

    public ResponseObject deleteEmployee(UUID id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ServiceExceptionHolder.EntityNotFoundException("Employee", id));
        employeeRepository.delete(employee);
        return apiResponseService.sendDeleteResponse("Employee", employee);
    }
}
