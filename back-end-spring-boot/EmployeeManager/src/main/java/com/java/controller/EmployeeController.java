package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.EmployeeDto;
import com.java.service.EmployeeService;

@RestController
@Scope("prototype")
@RequestMapping("api/employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("all")
	public Object get() {
		try {
			List<EmployeeDto> dtos = new ArrayList<EmployeeDto>();
			dtos = employeeService.findAll();
			if (dtos == null)
				return new ResponseEntity<Object>("Không tìm thấy nhân viên nào",HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Object>(dtos,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Lỗi server",HttpStatus.BAD_REQUEST);
		}	
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable Long id) {
		try {
			EmployeeDto dto = employeeService.find(id);
			if(dto == null)
				return new ResponseEntity<Object>("Không tìm thấy id =  " + id,HttpStatus.BAD_GATEWAY);
			
			return new ResponseEntity<Object>(dto,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Lỗi server",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping("save")
		public Object post(@RequestBody EmployeeDto dto) {
			try {
				EmployeeDto dto2 = employeeService.save(dto);
				if (dto2 == null)
					return new ResponseEntity<Object>("Không thế thêm mới", HttpStatus.BAD_GATEWAY);
				return new ResponseEntity<Object>(dto2, HttpStatus.CREATED);	
					
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Object>("Lỗi server",HttpStatus.BAD_GATEWAY);
			}
		}
	@PutMapping("edit")
	public Object put( @RequestBody EmployeeDto dto) {
		try {
			EmployeeDto dto2 = employeeService.edit( dto);
			if (dto2 == null)
				return new ResponseEntity<Object>("Không tìm thấy id = " + dto.getId() ,HttpStatus.BAD_GATEWAY);
			return new ResponseEntity<Object>(dto2 ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Lỗi server",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public Object delete (@PathVariable Long id) {
		try {
			if(employeeService.delete(id) == -1)
				return new ResponseEntity<Object>("Không tìm thấy id = " + id ,HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Lỗi server",HttpStatus.BAD_GATEWAY);
		}
	}
	
}
