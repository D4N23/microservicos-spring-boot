package com.microservices.employeeservice.services.impl;

// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.employeeservice.dtos.ApiResponseDto;
import com.microservices.employeeservice.dtos.DepartmentDto;
import com.microservices.employeeservice.dtos.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.exceptions.EmployeeEmailAlreadyExistsException;
import com.microservices.employeeservice.mapper.EmployeeMapper;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.services.ApiClient;
import com.microservices.employeeservice.services.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    // private final RestTemplate restTemplate;
    private final WebClient webClient;
    // private ApiClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapTEmployee(employeeDto);
        Employee employeeEmail = repository.findEmployeeByEmail(employeeDto.getEmail());
        if (employeeEmail != null) {
            throw new EmployeeEmailAlreadyExistsException(
                    "The Email Already Exists. Please register with other Email Address!");
        }
        Employee saveEmployee = repository.save(employee);
        EmployeeDto saveEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveEmployee);
        return saveEmployeeDto;
    }

    // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeebyId(Long employeeId) {

        Employee employee = repository.findById(employeeId).get();
        var url = "http://localhost:8080/v1/departments/";

        // Utilizando Rest Template
        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(url
        // + employee.getDepartmentCode(),
        // DepartmentDto.class);
        // DepartmentDto departmentDto = responseEntity.getBody();

        // Utilizando Web Client do pacote spring Web-flux
        DepartmentDto departmentDto = webClient.get()
                .uri(url + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        // Utilizando o Open Feing
        // DepartmentDto departmentDto =
        // apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    public ApiResponseDto getDefaultDepartment(Long employeeId) {
        Employee employee = repository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("Research and Develoment Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
