package com.microservices.departmentservice.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.departmentservice.DepartmentServiceApplication;
import com.microservices.departmentservice.dtos.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.exceptions.DepartmentCodeAlreadyExistsException;
import com.microservices.departmentservice.exceptions.DepartmentNameAlreadyExixtsException;
import com.microservices.departmentservice.mapper.DepartmentMapper;
import com.microservices.departmentservice.repository.DepartmentRepository;
import com.microservices.departmentservice.services.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository repository;

    @Override
    public DepartmentDto savDepartment(DepartmentDto departmentDto) {
        // Converter o DepartamentoDto em uma entidade JPA
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department departmentCode = repository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if (departmentCode != null) {
            throw new DepartmentCodeAlreadyExistsException("Departament Code Already exists");
        }

         Department departmentName = repository.findByDepartmentName(departmentDto.getDepartmentName());
         if(departmentName != null){
            throw new DepartmentNameAlreadyExixtsException("The Department name Already Exists!!");
         }

        // Salva no Banco
        Department saveDepartment = repository.save(department);
        // Converte novamente em Dto
        DepartmentDto saveDepartmentDto = DepartmentMapper.mapToDepartmentDto(saveDepartment);
        // retorna o Obj DTO
        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department findDepartment = repository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(findDepartment);
        return departmentDto;
    }

}
