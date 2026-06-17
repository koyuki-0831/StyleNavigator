package com.koyuki.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.koyuki.demo.dto.request.CustomerRequestDto;
import com.koyuki.demo.dto.response.CustomerResponseDto;
import com.koyuki.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//顧客登録
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponseDto createCustomer(@Valid @RequestBody CustomerRequestDto requestDto) {
		return customerService.createCustomer(requestDto);
	}
	
	//顧客一覧取得
	@GetMapping
	public List<CustomerResponseDto> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	//顧客詳細取得
	@GetMapping("/{id}")
	public CustomerResponseDto getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	//顧客更新
	@PutMapping("/{id}")
	public CustomerResponseDto updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerRequestDto requestDto) {
		return customerService.updateCustomer(id, requestDto);
	}
	
	//顧客削除
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
}
