package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.java.dto.EmployeeDto;
import com.java.entity.Employee;
import com.java.repo.EmployeeRepo;
import com.java.service.EmployeeService;


@Service
@Scope("prototype")
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public EmployeeDto save(EmployeeDto dto) {
		dto.setEmployeeCode(UUID.randomUUID().toString());
		if(employeeRepo.save(new Employee(dto.getName(), dto.getEmail(), dto.getJobTitle(), 
				dto.getPhone(), dto.getImageUrl(), dto.getEmployeeCode())) == null)
			return null;
		return dto;
	}
	@Override
	public EmployeeDto edit(EmployeeDto dto) {
		if(!employeeRepo.existsById(dto.getId())) {
			return null;
		}
		Employee entity = employeeRepo.findById(dto.getId()).get();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setJobTitle( dto.getJobTitle());
		entity.setPhone(dto.getPhone());
		entity.setImageUrl( dto.getImageUrl());
		employeeRepo.save(entity);
		return dto;
	}

	@Override
	public int delete(Long id) {
		if(!employeeRepo.existsById(id)) {
			return -1;
		}
		employeeRepo.deleteById(id);
		return 0;
	}

	@Override
	public EmployeeDto find(Long id) {
		if(!employeeRepo.existsById(id)) {
			return null;
		}
		Employee enEmployee = employeeRepo.findById(id).get();
		return new EmployeeDto(enEmployee.getName(), enEmployee.getEmail(), enEmployee.getJobTitle(), 
				enEmployee.getPhone(), enEmployee.getImageUrl(), enEmployee.getEmployeeCode());
	}

	@Override
	public List<EmployeeDto> findAll() {
		List<Employee> employees = employeeRepo.findAll();
		if(employees.size() ==  0) {
			return null;
		}
		List<EmployeeDto> dtos = new ArrayList<EmployeeDto>();			
		for(Employee employee : employees) {
			EmployeeDto dto = new EmployeeDto(employee.getId(), employee.getName(), employee.getEmail(),
					employee.getJobTitle(), employee.getPhone(), employee.getImageUrl(), employee.getEmployeeCode());
			dtos.add(dto);
		}
		return dtos;
	}
	
}
